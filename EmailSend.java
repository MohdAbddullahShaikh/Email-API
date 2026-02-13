package in.sterling.EmailSending;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSend{

	// SMTP Server
	private static final String SMTP_SERVER = "bh-ht-3.webhostbox.net";

	// SMTP Server Port Number
	private static final int SMTP_PORT = 465;

	// SMTP Login
	private static final String LOGIN = "webmaster@sterlinginstitute.in";

	// SMTP Password
	private static final String PASSWORD = "$terling@1234";

	private static Properties prp = new Properties();

	static {

		prp.put("mail.transport.protocol", "smtps");
		prp.put("mail.smtps.host", SMTP_SERVER);
		prp.put("mail.smtps.port", SMTP_PORT);
		prp.put("mail.smtps.auth", "true");
	}

	
	private static String from = "webmaster@sterlinginstitute.in";
	private static String to = "mayankanilchoudhary@gmail.com";

	
	public static void sendTextEmail() throws Exception {

		String subject = "My First Email from Java Mail API";

		String msg = "Hello mayank, This is a Message from Sterling Institute.";

		// Load the configuration
		Session session = Session.getDefaultInstance(prp);

		// To create message by MimeMessage class
		MimeMessage message = new MimeMessage(session);

		// Call setter methods and set the properties
		message.setFrom(new InternetAddress(from));

		// Recipient Add
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		// add subject
		message.setSubject(subject);

		// add message
		message.setText(msg);

		Transport transport = session.getTransport();
		transport.connect(SMTP_SERVER, SMTP_PORT, LOGIN, PASSWORD);

		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}

	
	
	
	public static void main(String[] args) throws Exception {

		sendTextEmail();
		System.out.println("Email Sent Successfully");

	}


}
