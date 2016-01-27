/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:45:07</p>
 */
package com.lezic.core.orm.service;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.lezic.core.orm.Page;
import com.lezic.core.orm.dao.IBaseDAO;
import com.lezic.core.util.UtilReflection;

/**
 * 基础服务类
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

	
	public boolean isRepeat(String hql, Object... values) {
		return baseDAO.isRepeat(hql, values);
	}

	
	public Object findOneH(String hql, boolean ignoreErr, Object... values) {
		return baseDAO.findOneH(hql, ignoreErr, values);
	}

	/**
	 * 判断数据库表是否存在
	 * @param tableName
	 * @return
	 * @author cielo
	 */
	public boolean isTableExist(String tableName){
		return baseDAO.isTableExist(tableName);
	}

}
