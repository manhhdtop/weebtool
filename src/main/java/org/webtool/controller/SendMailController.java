package org.webtool.controller;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendMailController
{
	@RequestMapping(value = { "/gui-mail" })
	public String doSendEmail(HttpServletRequest request)
	{
		// takes input from e-mail form
		String from = request.getParameter("email");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		String username = "hoangmd265@gmail.com";
		String password = "nobita123";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(username, password);
			}
		});
		
		try
		{
			
			Message mess = new MimeMessage(session);
			mess.setFrom(new InternetAddress(from, "Takatori", "UTF-8"));
			mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
			mess.setSubject("Send by Contact");
			mess.setText("From " + name + "\n\nEmail: " + from + "\n\nSubject: " + subject
			        + "\n\nMessage:\n" + message);
			
			Transport.send(mess);
		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return "lien-he";
	}
}
