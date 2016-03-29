/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 下午1:54:42</p>
 */
package com.lezic.core.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 账户认证
 * 
 * @author cielo
 * 
 */
public class EmailAuthenticator extends Authenticator {

	/** 发送方：用户名 */
	private String user;

	/** 发送方：密码 */
	private String password;

	/**
	 * 账户认证构造方法
	 * 
	 * @param user
	 *            账户
	 * @param password
	 *            密码
	 */
	public EmailAuthenticator(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	/**
	 * 账户认证构造方法
	 * 
	 * @param user
	 *            账户
	 * @param password
	 *            密码
	 * @param nickName
	 *            昵称
	 */
	public EmailAuthenticator(String user, String password, String nickName) {
		super();
		this.user = user;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, password);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
