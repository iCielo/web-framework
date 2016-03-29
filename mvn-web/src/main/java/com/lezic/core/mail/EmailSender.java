/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 下午2:53:29</p>
 */
package com.lezic.core.mail;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;

import com.lezic.core.util.UtilData;

/**
 * 邮件发送类
 * 
 * @author cielo
 * 
 */
public class EmailSender {

	/** 日志 */
	private Logger logger = Logger.getLogger(EmailSender.class);

	/** 会话 */
	private Session session;

	private Address from;

	/**
	 * 构造方法
	 * 
	 * @param props
	 *            邮件参数设置
	 * @param user
	 *            账户
	 * @param password
	 *            用户名
	 * @param auth
	 * @throws AddressException
	 */
	public EmailSender(EmailProperties props, String user, String password) throws AddressException {
		EmailAuthenticator auth = new EmailAuthenticator(user, password);
		this.session = Session.getInstance(props, auth);
		this.from = new InternetAddress(user);
	}

	/**
	 * 构造方法
	 * 
	 * @param props
	 *            邮件参数设置
	 * @param user
	 *            账户
	 * @param password
	 *            用户名
	 * @param auth
	 * @throws UnsupportedEncodingException
	 * @throws AddressException
	 */
	public EmailSender(EmailProperties props, String user, String password, String nickName)
			throws UnsupportedEncodingException, AddressException {
		EmailAuthenticator auth = new EmailAuthenticator(user, password);
		this.session = Session.getInstance(props, auth);
		if (UtilData.isNotNull(nickName)) {
			nickName = MimeUtility.encodeText(nickName);
			from = new InternetAddress(nickName + "<" + user + ">");
		} else {
			from = new InternetAddress(user);
		}
	}

	/**
	 * 发送邮件
	 * 
	 * @param email
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 * @author cielo
	 */
	public void sendEmail(Email email)  {
		logger.debug("发送邮件中......");
		try {
			Message message = new MimeMessage(session);
			message.setFrom(this.from);
			message.setSubject(email.getSubject());

			Multipart multipart = new MimeMultipart();

			// 内容
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(email.getContent(), "text/html;charset=utf-8");
			multipart.addBodyPart(messageBodyPart);

			List<String[]> attaList = email.getAttaList();
			// 附件
			if (attaList != null && attaList.size() != 0) {
				for (Iterator<String[]> iterator = attaList.iterator(); iterator.hasNext();) {
					String[] item = iterator.next();
					String fileName = item[0];
					String filePath = item[1];
					File file = new File(filePath);
					if (file.isDirectory() || file.exists() == false) {
						continue;
					}
					DataSource source = new FileDataSource(filePath);
					BodyPart attaBodyPart = new MimeBodyPart();
					attaBodyPart.setDataHandler(new DataHandler(source));
					attaBodyPart.setFileName(MimeUtility.encodeText(fileName));
					multipart.addBodyPart(attaBodyPart);
				}
			}

			// Send the complete message parts
			message.setContent(multipart);
			message.setRecipients(Message.RecipientType.TO, email.getRecipients());

			Transport.send(message);
		} catch (Exception e) {
			throw new EmailException(e);
		}

		logger.debug("发送邮件结束......成功发送！");
	}

	/**
	 * 发送简单消息邮件
	 * 
	 * @param subject
	 *            主题
	 * @param text
	 *            消息
	 * @param addresses
	 *            收件人地址
	 * @throws MessagingException
	 * @author cielo
	 * @throws UnsupportedEncodingException
	 */
	public void sendText(String subject, String text, Address... addresses)  {
		try {
			logger.debug("发送简单消息邮件......");
			Message message = new MimeMessage(session);
			message.setFrom(this.from);
			message.setSubject(subject);
			message.setText(text);
			message.setRecipients(Message.RecipientType.TO, addresses);
			Transport.send(message);
			logger.debug("发送简单消息邮件......成功！");
		} catch (Exception e) {
			throw new EmailException(e);
		}
	}

	/**
	 * 发送html格式的邮件
	 * 
	 * @param subject
	 *            主题
	 * @param content
	 *            内容
	 * @param addresses
	 *            收件人地址
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 * @author cielo
	 */
	public void sendHtml(String subject, String content, Address... addresses) {
		try {
			logger.debug("发送HTML格式的邮件......");
			Message message = new MimeMessage(session);
			message.setFrom(this.from);
			message.setSubject(subject);
			message.setContent(content, "text/html;charset=utf-8");
			message.setRecipients(Message.RecipientType.TO, addresses);
			Transport.send(message);
			logger.debug("发送HTML格式的邮件......成功！");
		} catch (Exception e) {
			throw new EmailException(e);
		}
	}

	/**
	 * 发送带附件的邮件
	 * 
	 * @param subject
	 *            主题
	 * @param content
	 *            内容
	 * @param attaList
	 *            附件集合，文件绝对路径
	 * @param addresses
	 *            收件人地址
	 * @author cielo
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public void sendHtmlAndAtta(String subject, String content, List<String[]> attaList, Address... recipients)
			 {
		Email email = new Email();
		email.setSubject(subject);
		email.setContent(content);
		email.setAttaList(attaList);
		email.setRecipients(recipients);
		this.sendEmail(email);
	}

}
