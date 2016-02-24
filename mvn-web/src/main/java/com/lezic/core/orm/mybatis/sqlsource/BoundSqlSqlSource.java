/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午5:27:54</p>
 */
package com.lezic.core.orm.mybatis.sqlsource;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @author cielo
 *
 */
public class BoundSqlSqlSource implements SqlSource {

	private final BoundSql boundSql;

	public BoundSqlSqlSource(MappedStatement ms, BoundSql boundSql, String sql) {
		this.boundSql = buildBoundSql(ms, boundSql, sql);
	}

	@Override
	public BoundSql getBoundSql(Object parameterObject) {
		return boundSql;
	}

	private BoundSql buildBoundSql(MappedStatement ms, BoundSql boundSql, String sql) {
		BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql, boundSql.getParameterMappings(),
				boundSql.getParameterObject());
		for (ParameterMapping mapping : boundSql.getParameterMappings()) {
			String prop = mapping.getProperty();
			if (boundSql.hasAdditionalParameter(prop)) {
				newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
			}
		}
		return newBoundSql;
	}

}
