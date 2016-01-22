/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:45:07</p>
 */
package com.lezic.core.orm.service.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.lezic.core.orm.Page;
import com.lezic.core.orm.dao.IBaseDAO;
import com.lezic.core.orm.service.IBaseService;
import com.lezic.core.util.UtilReflection;

/**
 * 基础服务实现类
 * 
 * @author cielo
 *
 */
public class BaseServiceImpl<T> implements IBaseService<T>, InitializingBean {

	@Autowired
	IBaseDAO baseDAO;

	protected Class<T> entityClass;

	@Override
	public void afterPropertiesSet() throws Exception {
		entityClass = UtilReflection.getSuperClassGenricType(getClass());
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getH(Serializable id) {
		return (T) baseDAO.getH(entityClass, id);
	}

	@Override
	public Serializable saveH(T entity) {
		return baseDAO.saveH(entity);
	}

	@Override
	public void updH(T entity) {
		baseDAO.updH(entity);
	}

	@Override
	public void delH(T entity) {
		baseDAO.delH(entity);
	}
	
	@Override
	public int batchDelH(Class<?> cl, Serializable[] ids) {
		return baseDAO.batchDelH(cl, ids);
	}

	@Override
	public void saveOrUpdH(T entity) {
		baseDAO.saveOrUpdH(entity);
	}

	@Override
	public void pageH(Page<T> page, String hql, Object... values) {
		baseDAO.pageH(page, hql, values);

	}

	@Override
	public void pageH(Page<T> page, String hql, Map<String, Object> params) {
		baseDAO.pageH(page, hql, params);
	}

	@Override
	public boolean isRepeat(String hql, Object... values) {
		return baseDAO.isRepeat(hql, values);
	}

	@Override
	public Object findOneH(String hql, boolean ignoreErr, Object... values) {
		return baseDAO.findOneH(hql, ignoreErr, values);
	}



}
