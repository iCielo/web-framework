/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午5:33:29</p>
 */
package com.lezic.core.orm.mybatis.util;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;

import com.lezic.core.orm.mybatis.sqlsource.BoundSqlSqlSource;

/**
 * @author cielo
 *
 */
public class UtilMappedStatement {
	
	public MappedStatement buildMappedStatement(MappedStatement ms, BoundSql boundSql, String sql) {
		Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(),
				new BoundSqlSqlSource(ms, boundSql, sql), ms.getSqlCommandType());

		builder.resource(ms.getResource());
		builder.parameterMap(ms.getParameterMap());
		builder.resultMaps(ms.getResultMaps());
		builder.fetchSize(ms.getFetchSize());
		builder.timeout(ms.getTimeout());
		builder.statementType(ms.getStatementType());
		builder.resultSetType(ms.getResultSetType());
		builder.cache(ms.getCache());
		builder.flushCacheRequired(ms.isFlushCacheRequired());
		builder.useCache(ms.isUseCache());
		builder.keyGenerator(ms.getKeyGenerator());
		builder.keyProperty(delimitedArraytoString(ms.getKeyProperties()));
		builder.keyColumn(delimitedArraytoString(ms.getKeyColumns()));
		builder.databaseId(ms.getDatabaseId());

		return builder.build();
	}

	private static String delimitedArraytoString(String[] in) {
		if (in == null || in.length == 0) {
			return null;
		} else {
			StringBuffer answer = new StringBuffer();
			for (String str : in) {
				answer.append(str).append(",");
			}
			return answer.toString();
		}
	}
}
