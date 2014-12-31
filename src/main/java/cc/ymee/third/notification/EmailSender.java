package cc.ymee.third.notification;

import cc.ymee.common.utils.MD5Utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 发送普通邮件，接受普通邮件 发送带有附件的邮件，接收带有附件的邮件 发送html形式的邮件，接受html形式的邮件 发送带有图片的邮件等做了一个总结。
 */
public class EmailSender {

    public static final String EMAIL_BODY_HEADER = "";

    private String MAIL_SUBJECT = "";

    private String PERSONAL_NAME = "";

	static class EmailSenderHolder {
		static EmailSender instance = new EmailSender();
	}

	public static EmailSender getInstance() {
		return EmailSenderHolder.instance;
	}
	// 邮箱服务器
	private String host = "smtp.exmail.qq.com";
	private String username = "";
	private String password = "";


	private String mail_from = username;



	public EmailSender() {
	}

	/**
	 * 此段代码用来发送普通电子邮件
	 */
	public void send(String[] mailTo,String mailBody) throws Exception {
		try {
			Properties props = new Properties(); // 获取系统环境
			Authenticator auth = new Email_Autherticator(); // 进行邮件服务器用户认证
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(props, auth);
			// 设置session,和邮件服务器进行通讯。
			MimeMessage message = new MimeMessage(session);
			// message.setContent("foobar, "application/x-foobar"); // 设置邮件格式
			message.setSubject(MAIL_SUBJECT); // 设置邮件主题
			message.setText(mailBody); // 设置邮件正文
//			message.setHeader(mail_head_name, mail_head_value); // 设置邮件标题
			message.setSentDate(new Date()); // 设置邮件发送日期
			Address address = new InternetAddress(mail_from, PERSONAL_NAME);
			message.setFrom(address); // 设置邮件发送者的地址
			Address toAddress;
			for (int i = 0; i < mailTo.length; i++) {
				toAddress = new InternetAddress(mailTo[i]); // 设置邮件接收方的地址
				message.addRecipient(Message.RecipientType.TO, toAddress);
			}
			Transport.send(message); // 发送邮件
			System.out.println("send ok!");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}

	/**
	 * 用来进行服务器对用户的认证
	 */
	public class Email_Autherticator extends Authenticator {
		public Email_Autherticator() {
			super();
		}

		public Email_Autherticator(String user, String pwd) {
			super();
			username = user;
			password = pwd;
		}

		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	}
	
	public static void sendMail(String email,String content){
		String [] mailTo={email};//测试
		String mailBody=EMAIL_BODY_HEADER+content;
		try {
			EmailSender.getInstance().send(mailTo, mailBody);
		} catch (Exception e) {
			System.out.println("email send error:"+mailBody);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	//	sendMail("liuzhen@ok4s.com", "您的验证码为：1234");
    System.out.print(MD5Utils.encodeMD5("1234"));

	}

}
