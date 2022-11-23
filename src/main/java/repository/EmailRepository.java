/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author admin
 */
public class EmailRepository {
    private static final String email = "hieuhvph22974@fpt.edu.vn";
    private static final String pass = "eslzicjofsttqmtl";
    
    public static void sendEmail(String mailNhan){
        int code = (int) Math.floor(((Math.random() * 899999) + 100000));
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getInstance(props, 
                new Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(email, pass);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, 
                    InternetAddress.parse(mailNhan));
            message.setSubject("Password confirmation code");
            message.setText(code+"");
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
