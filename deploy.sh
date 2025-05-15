[200~#!/usr/bin/env bash
set -euo pipefail

# Lista de pastas dos projetos
projects=(
  Grupo01Projeto
  Grupo02Projeto
  Grupo03Projeto
  Grupo05Projeto
  Grupo06Projeto
  Grupo07Projeto
  Grupo08Projeto
  Grupo09Projeto
  Grupo10Projeto
  Grupo11Projeto
  Grupo12projeto
)

# Configurações da VPS
VPS_USER="root"
VPS_HOST="147.93.9.183"
REMOTE_DIR="/home/projeto-integrador"

# Cria pasta temporária pra coletar todos os jars
mkdir -p build-jars

for proj in "${projects[@]}"; do
  echo
  echo "=== Processando $proj ==="

  if [[ ! -d "$proj" ]]; then
    echo "⚠️  Pasta $proj não encontrada — pulando."
    continue
  fi

  cd "$proj"

  # Escolhe comando de build:
  if [[ -x "./mvnw" && -f ".mvn/wrapper/maven-wrapper.jar" ]]; then
    BUILD_CMD="./mvnw clean package -DskipTests"
  elif command -v mvn &> /dev/null; then
    BUILD_CMD="mvn clean package -DskipTests"
  else
    echo "⚠️  Nem mvnw nem mvn disponíveis em $proj — pulando."
    cd - >/dev/null
    continue
  fi

  echo "> Usando: $BUILD_CMD"
  $BUILD_CMD

  # Encontra o jar gerado
  JAR_FILE=""
  if [[ -d "target" ]]; then
    JAR_FILE=$(find target -name "*.jar" ! -name "*-sources.jar" ! -name "*-javadoc.jar" -print -quit)
  fi

  if [[ -z "$JAR_FILE" || ! -f "$JAR_FILE" ]]; then
    echo "⚠️  JAR não encontrado em $proj/target — pulando."
  else
    # Copia pra pasta build-jars, preservando o nome
    cp "$JAR_FILE" "../build-jars/"
    echo "> Copiado para build-jars/$(basename "$JAR_FILE")"
  fi

  cd - >/dev/null
done

echo
echo "=== TODOS os JARs estão em build-jars/ ==="
echo "Enviando tudo de uma vez para VPS..."

# Verifica se existem JARs para enviar
if [[ -n "$(ls -A build-jars)" ]]; then
  # Transfere com wildcard, mantendo nomes
  scp build-jars/*.jar "$VPS_USER@$VPS_HOST:$REMOTE_DIR/"
else
  echo "⚠️  Nenhum JAR encontrado em build-jars/ para enviar."
fi

echo
echo "✅ Deploy concluído!
Na VPS, em $REMOTE_DIR, você terá:
$(ssh $VPS_USER@$VPS_HOST "ls -1 $REMOTE_DIR")"
