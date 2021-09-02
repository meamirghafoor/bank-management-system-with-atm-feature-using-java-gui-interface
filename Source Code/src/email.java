
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amir Ghafoor
 */
public class email {
    void send(String to, String sms, String sub) {
        final String username = "your-email-account@gmail.com"; //provide sender email account here, only gmail account
        final String password = "your-email-account-password";// provide email account password here
        /*
        Note!!
        enable email account setting that you provide
         > enable less secure appp access setting
         >  IMAP setting should be enable
        */
        Properties props = new Properties();
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress(username, "Sky Bank Limited"));
            msg.setReplyTo(InternetAddress.parse(username, false));
            msg.setSubject(sub);
            msg.setText(sms);
            msg.setSentDate(new java.util.Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            Transport.send(msg);
            return;
        } catch (UnsupportedEncodingException | MessagingException e) {
            return;
        }
    }
    
}
