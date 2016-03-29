/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 下午2:49:36</p>
 */
package com.lezic.core.mail;

import java.util.List;

import org.apache.log4j.Logger;

import com.lezic.core.util.UtilData;

/**
 * 邮件发送任务
 * 
 * @author cielo
 * 
 */
public abstract class EmailTask implements Runnable {

	/** 日志 */
	private Logger logger = Logger.getLogger(getClass());

	private EmailSender emailSender;

	private List<Email> emailList;

	/**
	 * 邮件任务构造方法
	 * 
	 * @param emailSender
	 *            邮件发送类
	 * @param emailList
	 *            要发送的邮件列表
	 */
	public EmailTask(EmailSender emailSender,List<Email> emailList) {
		super();
		this.emailSender = emailSender;
		this.emailList = emailList;
	}

	@Override
	public void run() {
		if (emailSender != null && UtilData.isNotEmpty(emailList)) {
			int size = emailList.size();
			for (int i = 0; i < size; i++) {
				Email email = emailList.get(i);
				try {
					emailSender.sendEmail(email);
					this.success(email);
				} catch (Exception e) {
					logger.error("邮件发送失败！" + email.toString(), e);
					this.fail(email);
				}
			}
		}
	}

	/**
	 * 邮件发送成功
	 * 
	 * @author cielo
	 */
	public abstract void success(Email email);

	/**
	 * 邮件发送失败
	 * 
	 * @author cielo
	 */
	public abstract void fail(Email email);

}
