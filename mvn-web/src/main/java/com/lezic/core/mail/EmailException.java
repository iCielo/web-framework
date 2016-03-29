/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 上午9:02:43</p>
 */
package com.lezic.core.mail;

import java.util.HashMap;
import java.util.Map;

import javax.mail.AuthenticationFailedException;

import com.lezic.core.util.UtilRegex;

/**
 * 邮件异常类
 * 
 * @author cielo
 * 
 */
public class EmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/** 错误码 */
	private String errCode;

	/** 错误信息 */
	private String errMsg;

	private static Map<String, String> errMap = new HashMap<String, String>();

	static {
		errMap.put("535", "发件人账号登录认证失败");
	}

	public EmailException(Exception e) {
		String message = e.getMessage();
		if (e instanceof AuthenticationFailedException) {
			message = e.getMessage();
			errCode = UtilRegex.matchFirst(message, "^(\\d+)",1);
		}
		errMsg = errMap.get(errCode);
		if (errMsg == null) {
			errMsg = message;
		}
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String getMessage() {
		return this.errMsg;
	}

}
