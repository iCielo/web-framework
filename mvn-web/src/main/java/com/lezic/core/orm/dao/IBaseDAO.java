/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:06:54</p>
 */
package com.lezic.core.orm.dao;

import java.io.Serializable;

/**
 * 基础DAO接口类
 * 
 * @author cielo
 *
 */
public interface IBaseDAO {

	/**
	 * Hibernate：查找对象
	 * 
	 * @param cl
	 * @param id
	 *            主键
	 * @return
	 * @author cielo
	 */
	public Object getH(Class<?> cl, Serializable id);

	/**
	 * Hibernate：新增对象
	 * 
	 * @param entity
	 * @return
	 * @author cielo
	 */
	public Serializable saveH(Object entity);

	/**
	 * Hibernate：修改对象
	 * 
	 * @param entity
	 * @author cielo
	 */
	public void updH(Object entity);

	/**
	 * Hibernate：删除对象
	 * 
	 * @param entity
	 * @author cielo
	 */
	public void delH(Object entity);

	/**
	 * Hibernate：新增或修改对象
	 * 
	 * @param entity
	 * @author cielo
	 */
	public void saveOrUpdH(Object entity);
}
