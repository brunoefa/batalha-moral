package com.senai.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.senai.model.Usuario;

public class SendMail {

	public void send(String to, Usuario usuario) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("brunoefa","xpomkdklvnvbcosl");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("password@batalhamoral.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Recuperação de Senha - Batalha Moral");
			message.setText("Ola,\n\n"
						  + "Conforme solicitado, segue o link de acesso para redefinição senha:\n\n"
						  + "http://localhost:8080/bm/usuario?acao=redefinir&id="+ usuario.getId() +"&recuperacao=" + usuario.getRecuperacao() +" \n\n"
						  + "Acesse o link acime para que uma nova senha seja criada:\n\n"
					  	  + "Att.");

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}