/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 下午3:23:58</p>
 */
package com.lezic.core.mail;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

/**
 * @author cielo
 * 
 */
public class EmailClient {

	public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
		EmailProperties props = new EmailProperties();
		props.setProperty("mail.debug", "true");
		props.setProperty("mail.smtp.host", "smtp.qq.com");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.ssl.enable", "true");

		InternetAddress[] recipients = new InternetAddress[] { new InternetAddress("lincl@nfky.com") };

		EmailSender mailSender = new EmailSender(props, "邮箱地址", "密码", "cielo");
		mailSender.sendText("test", "这是一封测试邮件", recipients);

		// String html = "<h1>hello</h1><a href=\"http://blog.sina.com.cn/s/blog_537398b10100ossg.html\">博客</>";
		// mailSender.sendHtml("xxx", html, recipients);

		// List<String[]> list = new ArrayList<String[]>();
		// list.add(new String[]{"文件名","F:\\123.xlsx"});
		// list.add(new String[]{"文件名","F:\\意见反馈导入模板.xlsx"});
		// mailSender.sendHtmlAndAtta("带有附件的邮件", html, list, recipients);
	}
}
