/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016年1月16日 下午12:16:19</p>
 */
package com.lezic.core.orm.util;

import java.util.Collection;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.springframework.util.Assert;

/**
 * org.hibernate.Query的工具类
 * 
 * @author cielo
 *
 */
public class UtilQuery {

	/**
	 * 日志
	 */
	private static Logger logger = LogManager.getLogger();

	/**
	 * 设置Query的参数值
	 * 
	 * @param query
	 * @param values
	 */
	public static void setValues(Query query, Object... values) {
		Assert.notNull(query);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
	}

	/**
	 * 设置Query的参数值
	 * 
	 * @param query
	 * @param params
	 */
	public static void setValues(Query query, Map<String, Object> params) {
		Assert.notNull(query);
		if (params != null) {
			String[] nameParams = query.getNamedParameters();
			for (String nameParam : nameParams) {
				if (params.get(nameParam) instanceof Collection) {// 参数是个集合
					query.setParameterList(nameParam, (Collection<?>) params.get(nameParam));
				} else {
					query.setParameter(nameParam, params.get(nameParam));
				}
			}
		}
	}

	/**
	 * 获取count的查询字符串 hibernate、sql通用
	 * 
	 * @param queryString
	 * @return
	 */
	public static String getCountQuery(String queryString) {
		String regex = "(?i)\\s+order\\s+by\\s+[^)]+";
		String countQueryString = queryString.replaceAll(regex, "");
		if(countQueryString.startsWith("from")){
			countQueryString = "select count(1) " + countQueryString;
		}else{
			countQueryString = "select count(1) from (" + countQueryString + ") a";	
		}		
		logger.debug("统计语句：" + countQueryString);
		return countQueryString;
	}

}
