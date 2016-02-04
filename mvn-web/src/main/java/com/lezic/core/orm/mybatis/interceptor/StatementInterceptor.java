/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 上午10:05:06</p>
 */
package com.lezic.core.orm.mybatis.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author cielo
 *
 */
@Component
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class StatementInterceptor implements Interceptor {

	private Logger logger = LogManager.getLogger(getClass());

	private boolean showSql = true;

	private boolean format = true;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler target = (StatementHandler) invocation.getTarget();
		BoundSql boundSql = target.getBoundSql();
		String sql = boundSql.getSql();
		if (showSql) {
			if (format) {
				logger.debug("MyBatis: " + sql.replaceAll("\\s+", " "));
			} else {
				logger.debug("MyBatis: " + sql);
			}
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object object) {
		return Plugin.wrap(object, this);
	}

	@Override
	public void setProperties(Properties arg0) {

	}

}
