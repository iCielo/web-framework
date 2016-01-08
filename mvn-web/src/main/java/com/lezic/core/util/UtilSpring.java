/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午2:51:05</p>
 */
package com.lezic.core.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author cielo
 *
 */
public class UtilSpring {
	
	public static WebApplicationContext webApplicationContext;

	public static ServletContextEvent servletContextEvent;

	public static ServletContext servletContext;

	public static void init(ServletContextEvent event) {
		servletContextEvent = event;
		servletContext = event.getServletContext();
		webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	}

	public static Object getBean(String beanId) {
		return webApplicationContext.getBean(beanId);
	}

	/**
	 * 获取WebRoot绝对路径
	 * 
	 * @return
	 * @author cielo
	 */
	public static String getWebRootPath() {
		return servletContext.getRealPath("/");
	}
}
