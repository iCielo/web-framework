/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:45:07</p>
 */
package com.lezic.core.orm.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.lezic.core.lang.ParamMap;
import com.lezic.core.orm.Page;
import com.lezic.core.orm.dao.IBaseDAO;
import com.lezic.core.util.UtilReflection;

/**
 * 基础服务类 方法名 以H结尾代表hibernate用法，以M结尾代表mybatis，以S结尾代表SQL
 * 
 * @author cielo
 *
 */
public class BaseService<T> implements InitializingBean {

	@Autowired
	IBaseDAO baseDAO;

	protected Class<T> entityClass;

	public void afterPropertiesSet() throws Exception {
		entityClass = UtilReflection.getSuperClassGenricType(getClass());
	}

	@SuppressWarnings("unchecked")
	public T getH(Serializable id) {
		return (T) baseDAO.getH(entityClass, id);
	}

	public Serializable saveH(T entity) {
		return baseDAO.saveH(entity);
	}

	/**
	 * 批量保存对象
	 * 
	 * @param list
	 * @return
	 * @author cielo
	 */
	public Serializable[] batchSaveH(List<?> list) {
		return baseDAO.batchSaveH(list);
	}

	public void updH(T entity) {
		baseDAO.updH(entity);
	}

	public void delH(T entity) {
		baseDAO.delH(entity);
	}

	public int batchDelH(Class<?> cl, Serializable[] ids) {
		return baseDAO.batchDelH(cl, ids);
	}

	public void saveOrUpdH(T entity) {
		baseDAO.saveOrUpdH(entity);
	}

	public void pageH(Page<T> page, String hql, Object... values) {
		baseDAO.pageH(page, hql, values);

	}

	public void pageH(Page<T> page, String hql, Map<String, Object> params) {
		baseDAO.pageH(page, hql, params);
	}

	public boolean isExist(String hql, Object... values) {
		return baseDAO.isExistH(hql, values);
	}

	public Object findOneH(String hql, boolean ignoreErr, Object... values) {
		return baseDAO.findOneH(hql, ignoreErr, values);
	}

	/**
	 * 判断数据库表是否存在
	 * 
	 * @param tableName
	 * @return
	 * @author cielo
	 */
	public boolean isTableExist(String tableName) {
		return baseDAO.isTableExist(tableName);
	}

	/**
	 * 查询获取集合
	 * 
	 * @param hql
	 * @param values
	 * @return
	 * @author cielo
	 */
	public List<?> findH(String hql, Object... values) {
		return baseDAO.findH(hql, values);
	}
	
	/**
	 * 执行hql语句
	 * @param hql
	 * @param values
	 * @return
	 * @author cielo
	 */
	public int executeH(String hql, ParamMap params){
		return baseDAO.executeH(hql, params);
	}
	
	/**
	 * 查询获取集合
	 * 
	 * @param statement
	 * @param params
	 * @return
	 * @author cielo
	 */
	public List<Object> findM(String statement, ParamMap params) {
		return baseDAO.findM(statement, params);
	}

	/**
	 * 查询分页
	 * 
	 * @param page
	 * @param statement
	 * @param params
	 * @author cielo
	 */
	public void pageM(Page<?> page, String statement, ParamMap params) {
		baseDAO.pageM(page, statement, params);
	}

}
