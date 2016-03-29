/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 下午2:25:28</p>
 */
package com.lezic.core.mail;

import java.util.Properties;

/**
 * 邮件默认配置
 * 
 * @author cielo
 * 
 */
public class EmailProperties extends Properties {

	private static final long serialVersionUID = 1L;

	/** 开启debug调试 */
	private String mailDebug = "false";

	/** 发送服务器需要身份验证 */
	private String mailSmtpAuth = "true";

	/** 设置邮件服务器主机名 */
	private String mailSmtpHost = "smtp.163.com";

	/** 设置邮件服务器端口，开启ssl时，一般为465 */
	private String mailSmtpPort = "25";

	/** 发送邮件协议名称 */
	private String mailTransportProtocol = "smtp";

	/** 是否开启SSL认证，如qq邮箱就要开启 */
	private String mailSmtpSslEnable = "false";

	public EmailProperties() {
		super();
		this.setProperty("mail.debug", mailDebug);
		this.setProperty("mail.smtp.auth", mailSmtpAuth);
		this.setProperty("mail.smtp.host", mailSmtpHost);
		this.setProperty("mail.smtp.port", mailSmtpPort);
		this.setProperty("mail.smtp.ssl.enable", mailSmtpSslEnable);
		this.setProperty("mail.transport.protocol", mailTransportProtocol);
	}

}
