/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 下午2:59:46</p>
 */
package com.lezic.core.web.interceptor;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lezic.core.util.UtilClientIp;

/**
 * 客户端请求地址、参数的打印拦截器
 * 
 * @author cielo
 *
 */
public class RequestLogInterceptor extends HandlerInterceptorAdapter {
	
	/** 日志 */
	private Logger logger = LogManager.getLogger();

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String reqString = request.getRequestURL() + "?"
				+ (request.getQueryString() == null ? "" : request.getQueryString());
		Map<?, ?> map = request.getParameterMap();
		Iterator<?> it = map.entrySet().iterator();
		logger.info("******");
		logger.info("Session ID：" + request.getSession().getId());
//		logger.info("Request userID：" + SessionParams.getUserId());
		logger.info("Request url : " + request.getRequestURL());
		logger.info("Client ip : " + UtilClientIp.getRemoteAddr(request));
		if (it.hasNext()) {
			logger.debug("------");
			while (it.hasNext()) {
				Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
				String[] value = (String[]) entry.getValue();
				StringBuffer str = new StringBuffer();
				for (int i = 0; i < value.length; i++) {
					str.append(value[i]);
					if (i != value.length - 1) {
						str.append(",");
					}
				}
				if (entry.getKey().contains("password") || entry.getKey().contains("pwd")) {
					logger.debug(entry.getKey() + " : *****");
				} else {
					logger.debug(entry.getKey() + " : " + str.toString());
				}
			}
			logger.debug("------");
		}
		return super.preHandle(request, response, handler);
	}
}
