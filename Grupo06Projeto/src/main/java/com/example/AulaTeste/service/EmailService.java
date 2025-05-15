package com.example.AulaTeste.service;


import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void ConfirmacaoReserva(String para, String nome) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setFrom("projetogrupo3@escolatecnicaadelia.com.br");
            helper.setTo(para);
            helper.setSubject("Reserva Confirmada!");

            String htmlContent = String.format("""
                <html>
                    <body>
                        <p>Sua reserva foi confimada para o pet %s</p>
                        <p>Aguardamos ansiosamente a sua presença.</p>
                        <br>
                        <p>Atenciosamente,<br>
                        EcoPet</p>
                    </body>
                </html>
                """, nome);

            helper.setText(htmlContent, true);

            System.out.println("Tentando enviar email para: " + para);
            mailSender.send(mimeMessage);
            System.out.println("Email enviado com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro detalhado ao enviar email:");
            e.printStackTrace(); // Isso vai mostrar a stack trace completa
            throw new RuntimeException("Erro ao enviar email: " + e.getMessage());
        }
    }


}
