package edu.ucr.rp.clinicadenutricion.Utilitario;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnviarCorreo {

    /**
     * método que envía mensaje a correo electrónico
     *
     * @param correo correo al que será enviado
     * @param tema tema del correo, será mostrado como título del correo
     * @param texto texto que incluirá el correo
     */
    public void sendMessage(String correo, String tema, String texto) {

        String to = correo;
        String from = "ClinicaSusanaDistancia@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ClinicaSusanaDistancia@gmail.com", "Algoritmos");
            }
        });

        session.setDebug(true);

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(tema);
            message.setText(texto);
            System.out.println("Enviando...");
            Transport.send(message);
            System.out.println("Mensaje enviado con éxito");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    /**
     * método que envía correo electrónico y pdf
     *
     * @param correo correo al que será enviado
     * @param tema tema del mensaje
     * @param pdf nombre del archivo pdf que será enviado
     * @param text texto del mensaje que será enviado
     * @throws IOException lanza la excepción de input output para evitar
     * problemas
     */
    public void sendPDF(String correo, String tema, String pdf, String text) throws IOException {

        String to = correo;
        String from = "ClinicaSusanaDistancia@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ClinicaSusanaDistancia@gmail.com", "Algoritmos");
            }
        });

        session.setDebug(true);

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(tema);
            Multipart multipart = new MimeMultipart();

            MimeBodyPart attachmentPart = new MimeBodyPart();

            MimeBodyPart textPart = new MimeBodyPart();

            try {

                File f = new File(pdf + ".pdf");

                attachmentPart.attachFile(f);
                textPart.setText(text);
                multipart.addBodyPart(textPart);
                multipart.addBodyPart(attachmentPart);

            } catch (IOException e) {

                e.printStackTrace();

            }

            message.setContent(multipart);

            System.out.println("Enviando...");
            Transport.send(message);
            System.out.println("Mensaje enviado con éxito");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}
