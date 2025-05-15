document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("reservasForm");
  const errorMessage = document.querySelector(".error-message");
  const successMessage = document.querySelector(".success-message");
  const submitButton = form.querySelector('button[type="submit"]');

  // Texto original do botão
  const originalButtonText = submitButton.textContent;

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    // Esconder mensagens anteriores
    errorMessage.style.display = "none";
    successMessage.style.display = "none";

    // Alterar botão para indicar processamento
    submitButton.disabled = true;
    submitButton.textContent = "Processando...";

    // Obter dados do formulário
    const nomeUsuario = document.getElementById("nome-usuario").value;
    const emailUsuario = document.getElementById("email-usuario").value;
    const nomeAnimal = document.getElementById("pet-name").value;
    const dataEntrada = document.getElementById("data-entrada").value;
    const dataSaida = document.getElementById("data-saida").value;

    // Validar datas
    const dataEntradaObj = new Date(dataEntrada);
    const dataSaidaObj = new Date(dataSaida);

    if (dataSaidaObj <= dataEntradaObj) {
      errorMessage.textContent =
        "A data de saída deve ser posterior à data de entrada.";
      errorMessage.style.display = "block";
      submitButton.disabled = false;
      submitButton.textContent = originalButtonText;
      return;
    }

    // Criar objeto de reserva
    const reserva = {
      nomeUsuario: nomeUsuario,
      EmailUsuario: emailUsuario,
      nomeAnimal: nomeAnimal,
      dataEntrada: dataEntrada,
      dataSaida: dataSaida,
    };

    // Enviar requisição para o backend
    fetch("/reservas/criar", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(reserva),
    })
      .then((response) => {
        if (!response.ok) {
          return response.text().then((text) => {
            throw new Error(text);
          });
        }
        return response.json();
      })
      .then((data) => {
        // Sucesso
        successMessage.textContent =
          "Reserva realizada com sucesso! Um email de confirmação foi enviado.";
        successMessage.style.display = "block";
        form.reset();

        // Rolar para a mensagem de sucesso
        successMessage.scrollIntoView({ behavior: "smooth" });

        // Restaurar botão
        submitButton.disabled = false;
        submitButton.textContent = originalButtonText;
      })
      .catch((error) => {
        // Erro
        errorMessage.textContent = "Erro ao enviar reserva: " + error.message;
        errorMessage.style.display = "block";

        // Rolar para a mensagem de erro
        errorMessage.scrollIntoView({ behavior: "smooth" });

        // Restaurar botão
        submitButton.disabled = false;
        submitButton.textContent = originalButtonText;
      });
  });

  // Definir data mínima como hoje
  const today = new Date().toISOString().split("T")[0];
  document.getElementById("data-entrada").min = today;
  document.getElementById("data-saida").min = today;
});
