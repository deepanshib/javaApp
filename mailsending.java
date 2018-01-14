package javaLove;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*; 
public class mailsending {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop=new Properties();
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.socketFactory.port","465");
		prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth","true");
		prop.put("mail.smtp.port","587");
		Session session = Session.getDefaultInstance(prop,    
		           new javax.mail.Authenticator() {    
		           protected PasswordAuthentication getPasswordAuthentication() {    
		           return new PasswordAuthentication("deepanshi116@gmail.com","************");  
		           }    
		          });    
		          try {    
		           MimeMessage message = new MimeMessage(session); 
		           message.setFrom(new InternetAddress("deepanshi116@gmail.com"));
		           message.addRecipient(Message.RecipientType.TO,new InternetAddress("deepanshibansal@ymail.com"));    
		           message.setSubject("Hello deepanshi");    
		           message.setText("be positive always");    
		           //send message  
		           Transport.send(message);    
		           System.out.println("message sent successfully");    
		          } catch (MessagingException e) {throw new RuntimeException(e);}  	}

}
//https://support.google.com/mail/answer/7126229?hl=en