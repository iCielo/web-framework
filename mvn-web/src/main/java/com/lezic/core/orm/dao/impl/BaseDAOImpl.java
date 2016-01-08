/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:12:16</p>
 */
package com.lezic.core.orm.dao.impl;

import java.io.Serializable;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.lezic.core.orm.dao.IBaseDAO;

/**
 * 基础DAO实现类
 * @author cielo
 *
 */
@Repository("baseDAO")
public class BaseDAOImpl implements IBaseDAO, InitializingBean {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private DataSource dataSource;

	private HibernateTemplate hibernateTemplate;

	private JdbcTemplate jdbcTemplate;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Object getH(Class<?> cl, Serializable id) {
		return hibernateTemplate.get(cl, id);
	}
	
	@Override
	public Serializable saveH(Object entity) {
		if (entity == null) {
			return null;
		}
		Serializable result = hibernateTemplate.save(entity);
		flushHiberate();
		return result;
	}

	@Override
	public void updH(Object entity) {
		hibernateTemplate.update(entity);
		flushHiberate();
	}

	@Override
	public void delH(Object entity) {
		hibernateTemplate.delete(entity);
		flushHiberate();
	}

	@Override
	public void saveOrUpdH(Object entity) {
		hibernateTemplate.saveOrUpdate(entity);
		flushHiberate();
	}

	/**
	 * 保证增删改的时候Hibernate及时将生成的SQL语句提交给数据库，而不是等到事务提交时。 保证查询出的对象，去掉其持久化的特性。
	 * 
	 * @return
	 */
	private void flushHiberate() {
		hibernateTemplate.flush();
		hibernateTemplate.clear();
	}

}
