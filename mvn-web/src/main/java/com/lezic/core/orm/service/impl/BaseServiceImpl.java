/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:45:07</p>
 */
package com.lezic.core.orm.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.lezic.core.orm.dao.IBaseDAO;
import com.lezic.core.orm.service.IBaseService;

/**
 * 基础服务实现类
 * 
 * @author cielo
 *
 */
public class BaseServiceImpl<T> implements IBaseService<T> {

	IBaseDAO baseDAOImpl;

	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	@Override
	public T getH(Serializable id) {
		return (T) baseDAOImpl.getH(entityClass, id);
	}

	@Override
	public Serializable saveH(T entity) {
		return baseDAOImpl.saveH(entity);
	}

	@Override
	public void updH(T entity) {
		baseDAOImpl.updH(entity);
	}

	@Override
	public void delH(T entity) {
		baseDAOImpl.delH(entity);
	}

	@Override
	public void saveOrUpdH(T entity) {
		baseDAOImpl.saveOrUpdH(entity);
	}

}
