package mailService;

import MVC.popUps;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailMain {

    public void sendMail(String bodyText, String customereMail, String subject) {
        //google settings
        Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("justlikeapenguin@gmail.com", "Jesus1313.");
            }
        });

        try {
            MimeMessage msg = new MimeMessage(session);
            String to = "jesusanchez40@gmail.com";
            InternetAddress[] address = InternetAddress.parse(to, true);
            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(bodyText);
            msg.setHeader("XPriority", "1");
            Transport.send(msg);
            popUps pops = new popUps();
            pops.outputText("messege has been sent");
        } catch (MessagingException mex) {
            System.out.println("Unable to send an email" + mex);
        }
    }
}
