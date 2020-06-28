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

    public void sendMessage(String correo, String tema, String texto) {

        String to = correo; //Recipient's email ID needs to be mentioned.
        String from = "ClinicaSusanaDistancia@gmail.com"; //Sender's email ID needs to be mentioned
        String host = "smtp.gmail.com";  // Assuming you are sending email from through gmails smtp
        Properties properties = System.getProperties(); // Get system properties

        properties.put("mail.smtp.host", host);// Setup mail server
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ClinicaSusanaDistancia@gmail.com", "Algoritmos");
            }
        });

        session.setDebug(true); // Used to debug SMTP issues

        try {

            MimeMessage message = new MimeMessage(session); // Create a default MimeMessage object.
            message.setFrom(new InternetAddress(from));// Set From: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// Set To: header field of the header.
            message.setSubject(tema);// Set Subject: header field
            message.setText(texto);// Now set the actual message
            System.out.println("Enviando...");
            Transport.send(message);// Send message
            System.out.println("Mensaje enviado con éxito");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public void sendPDF(String correo, String tema, String texto, String text) throws IOException {

        String to = correo; //Recipient's email ID needs to be mentioned.
        String from = "ClinicaSusanaDistancia@gmail.com"; //Sender's email ID needs to be mentioned
        String host = "smtp.gmail.com";  // Assuming you are sending email from through gmails smtp
        Properties properties = System.getProperties(); // Get system properties

        properties.put("mail.smtp.host", host);// Setup mail server
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ClinicaSusanaDistancia@gmail.com", "Algoritmos");
            }
        });

        session.setDebug(true); // Used to debug SMTP issues

        try {

            MimeMessage message = new MimeMessage(session); // Create a default MimeMessage object.
            message.setFrom(new InternetAddress(from));// Set From: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// Set To: header field of the header.
            message.setSubject(tema);// Set Subject: header field
            Multipart multipart = new MimeMultipart();

            MimeBodyPart attachmentPart = new MimeBodyPart();

            MimeBodyPart textPart = new MimeBodyPart();

            try {

                File f = new File(texto + ".pdf");

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
