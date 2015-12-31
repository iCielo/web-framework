/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 下午3:20:18</p>
 */
package com.lezic.core.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 客户端IP获取工具类
 * 
 * @author cielo
 *
 */
public class UtilClientIp {

	private static Logger logger = LogManager.getLogger();

	/**
	 * 获取请求用户地址
	 * 
	 * @param request
	 * @return
	 * @author cielo
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		String remoteAddr = request.getRemoteAddr();
		String xRealIp = request.getHeader("X-Real-IP");
		String xForwardedFor = request.getHeader("X-Forwarded-For");

		if (remoteAddr != null && !"".equals(remoteAddr) && !"127.0.0.1".equals(remoteAddr)) {
//			logger.debug("remoteAddr：" + remoteAddr);
			return remoteAddr;
		} else if (xRealIp != null && !"".equals(xRealIp) && !"127.0.0.1".equals(xRealIp)) {
			logger.debug("X-Real-IP:" + xRealIp);
			return xRealIp;
		} else if (xForwardedFor != null && !"".equals(xForwardedFor) && !"127.0.0.1".equals(xForwardedFor)) {
			logger.debug("X-Forwarded-For:" + xForwardedFor);
			return xForwardedFor;
		} else {
			logger.debug("remoteAddr：" + remoteAddr);
			return remoteAddr;
		}
	}
}
