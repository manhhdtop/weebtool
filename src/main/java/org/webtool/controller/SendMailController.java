package org.webtool.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Controller
public class SendMailController {
  @Value("${mail.username}")
  private String username;

  @Value("${mail.password}")
  private String password;

  @RequestMapping(value = {"/gui-mail"})
  public String doSendEmail(
      @RequestParam("email") String from,
      @RequestParam("name") String name,
      @RequestParam("subject") String subject,
      @RequestParam("message") String message) {
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session =
        Session.getInstance(
            props,
            new javax.mail.Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
              }
            });

    try {

      Message mess = new MimeMessage(session);
      mess.setFrom(new InternetAddress(from, "Takatori", "UTF-8"));
      mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
      mess.setSubject("Send by Contact");
      mess.setText(
          "From "
              + name
              + "\n\nEmail: "
              + from
              + "\n\nSubject: "
              + subject
              + "\n\nMessage:\n"
              + message);

      Transport.send(mess);
    } catch (MessagingException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return "lien-he";
  }
}
