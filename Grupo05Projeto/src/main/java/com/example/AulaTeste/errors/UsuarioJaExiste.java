package com.example.AulaTeste.errors;

public class UsuarioJaExiste extends RuntimeException {
  private String mensagem;
  public UsuarioJaExiste() {
    this.mensagem = "O usuario já existe";
  }

  public String getMensagem() {
      return mensagem;
  }

  public void setMensagem(String mensagem) {
      this.mensagem = mensagem;
  }
}
