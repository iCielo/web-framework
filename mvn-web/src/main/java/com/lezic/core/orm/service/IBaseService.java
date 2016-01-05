/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:44:37</p>
 */
package com.lezic.core.orm.service;

import java.io.Serializable;

/**
 * 基础服务接口类
 * @author cielo
 *
 */
public interface IBaseService<T> {

	/**
	 * Hibernate：查找对象
	 * 
	 * @param cl
	 * @param id
	 *            主键
	 * @return
	 * @author cielo
	 */
	public T getH(Serializable id);

	/**
	 * Hibernate：新增对象
	 * 
	 * @param entity
	 * @return
	 * @author cielo
	 */
	public Serializable saveH(T entity);

	/**
	 * Hibernate：修改对象
	 * 
	 * @param entity
	 * @author cielo
	 */
	public void updH(T entity);

	/**
	 * Hibernate：删除对象
	 * 
	 * @param entity
	 * @author cielo
	 */
	public void delH(T entity);

	/**
	 * Hibernate：新增或修改对象
	 * 
	 * @param entity
	 * @author cielo
	 */
	public void saveOrUpdH(T entity);
}
