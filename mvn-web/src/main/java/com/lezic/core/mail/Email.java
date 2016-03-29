/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 下午3:00:13</p>
 */
package com.lezic.core.mail;

import java.util.Arrays;
import java.util.List;

import javax.mail.Address;


/**
 * @author cielo
 * 
 */
public class Email {

	/** 接收地址 */
	private Address[] recipients;

	/** 主题 */
	private String subject;

	/** 内容 */
	private String content;

	/** 附件 new String[]{文件名,文件绝对路径}*/
	private List<String[]> attaList;

	public Address[] getRecipients() {
		return recipients;
	}

	public void setRecipients(Address[] recipients) {
		this.recipients = recipients;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public List<String[]> getAttaList() {
		return attaList;
	}

	public void setAttaList(List<String[]> attaList) {
		this.attaList = attaList;
	}

	@Override
	public String toString() {
		return "Email [recipients=" + Arrays.toString(recipients) + ", subject=" + subject + ", content=" + content
				+ ", attaList=" + attaList + "]";
	}

}
