package resourcesAndUtils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
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

public class Utils_SendEmail_WithAttachment {
	
public void sendEmailWithAttachment() {
		
		//Create object of Property File
		Properties props = new Properties();
		
		props.put("mail.smtp.starttls.enable", "true");
		
		//this will set host server - you can change based on your requirement
		props.put("mail.smtp.host", "smtp.gmail.com");
		
		//set the port of socket factory
		props.put("mail.smtp.socketFactory.port", "https");
		
		//set socket factory
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		//set the authentication to true
		props.put("mail.smtp.auth", true);
		
		//set the port of SMTP server
		props.put("mail.smtp.port", "https");
		
		//This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
				        
				new javax.mail.Authenticator() {
			
			    protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("praveen.bitsindri.pp@gmail.com","sonu@030164");
			}
		});
		
		try {
			
			//Create object of MimeMessage Class
			Message message = new MimeMessage(session);
			
			//Set the from Address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("praveen.bitsindri@gmail.com"));
			
			//Add the Subject Link
			message.setSubject("Selenium Testing Framework");
			
			//Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
			
			//Set the bodyof email
			messageBodyPart1.setText("Thsi is Message Body");
			
			//Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			
			//Mention the file which you want to send
			String filename = "emailable-report.html";
			
			//Create datasource and pass the filename
			DataSource source = new FileDataSource("F:\\Eclipse Projects\\Eclipse-Workspace\\Tourism\\test-output\\emailable-report.html");
			
			//Set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
			
			//set the file
			messageBodyPart2.setFileName(filename);
			
			//Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			
			//add body part 1
			multipart.addBodyPart(messageBodyPart2);
			
			//add body part 2
			multipart.addBodyPart(messageBodyPart1);
			
			//set the content
			message.setContent(multipart);
			
			//finally send the email
			Transport.send(message);
			
			System.out.println("=========Email Sent========");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
}

}
