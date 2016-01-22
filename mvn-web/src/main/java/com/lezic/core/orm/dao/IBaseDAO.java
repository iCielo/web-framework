/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:06:54</p>
 */
package com.lezic.core.orm.dao;

import java.io.Serializable;
import java.util.Map;

import com.lezic.core.orm.Page;

/**
 * 基础DAO接口类
 * 
 * 方法名 以H结尾代表hibernate用法，以M结尾代表mybatis，以S结尾代表SQL
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
	 * Hibernate：批量删除
	 * 
	 * @param cl
	 * @param ids
	 * @author cielo
	 * @return 
	 */
	public int batchDelH(Class<?> cl, Serializable[] ids);

	/**
	 * Hibernate：新增或修改对象
	 * 
	 * @param entity
	 * @author cielo
	 */
	public void saveOrUpdH(Object entity);

	/**
	 * 查询分页
	 * 
	 * @param page
	 *            分页对象。查询结果，存在Page的result中
	 * @param hql
	 * @param values
	 */
	public void pageH(Page<?> page, String hql, Object... values);

	/**
	 * 查询分页
	 * 
	 * @param page
	 *            分页对象。查询结果，存在Page的result中
	 * @param hql
	 * @param values
	 */
	public void pageH(Page<?> page, String hql, Map<String, Object> params);
	
	/**
	 * 判断是否重复
	 * @param hql = "from ClassName where (id != ? or ? is null) and name = ? and opUserid = ?";
	 * @param values 共需输入4个参数，即4个？对应的参数
	 * @return
	 * @author cielo
	 */
	public boolean isRepeat(String hql, Object... values);
	
	/**
	 * 查询获取一个对象
	 * @param hql
	 * @param ignoreErr 是否忽略错误。如存在多个的时候，false会报错，true不会保存
	 * @param values
	 * @return
	 * @author cielo
	 */
	public Object findOneH(String hql,boolean ignoreErr, Object... values);

}
