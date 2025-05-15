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

    public void enviarEmailCompra(String para, String produto) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setFrom("projetogrupo3@escolatecnicaadelia.com.br");
            helper.setTo(para);
            helper.setSubject("Compra confirmada!");

            String htmlContent = String.format("""
                <html>
                    <body>
                        <h2>Olá</h2>
                        <p>Seja Bem-Vindo à nossa loja!</p>
                        <p>Seu pedido foi efeteuado com sucesso.</p>
                        <br>
                        <p>Seu chinelo: %s está sendo produzido e irá ser entregue em 15 dias úteis</p>
                        <p>Atenciosamente,<br>
                        Equipe Ta no pé</p>
                    </body>
                </html>
                """, produto);

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
