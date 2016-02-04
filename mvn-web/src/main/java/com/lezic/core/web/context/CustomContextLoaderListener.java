/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午2:48:27</p>
 */
package com.lezic.core.web.context;

import javax.servlet.ServletContextEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

import com.lezic.core.cache.ehcache.UtilEhcache;
import com.lezic.core.util.UtilSpring;

/**
 * 系统启动初始化类
 * 
 * @author cielo
 *
 */
public class CustomContextLoaderListener extends ContextLoaderListener {

	Logger logger = LogManager.getLogger();

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		UtilSpring.init(event);
	}

}
