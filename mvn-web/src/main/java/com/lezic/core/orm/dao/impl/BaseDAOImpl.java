/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:12:16</p>
 */
package com.lezic.core.orm.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.lezic.core.orm.Page;
import com.lezic.core.orm.dao.IBaseDAO;
import com.lezic.core.orm.util.UtilQuery;

/**
 * 基础DAO实现类
 * 
 * @author cielo
 *
 */
@Repository("baseDAO")
@Transactional(readOnly = false)
public class BaseDAOImpl implements IBaseDAO, InitializingBean {

	/**
	 * 日志
	 */
	private Logger logger = LogManager.getLogger();

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

	public Session getSession() {
		return sessionFactory.openSession();
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
	public int batchDelH(Class<?> cl, Serializable[] ids) {
		String hql = "delete from " + cl.getSimpleName() + " where id in(:ids)";
		Query query = getSession().createQuery(hql);
		query.setParameterList("ids", ids);
		return query.executeUpdate();
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

	@SuppressWarnings("unchecked")
	@Override
	public void pageH(Page<?> page, String hql, Object... values) {
		Assert.notNull(page);
		Query countQuery = getSession().createQuery(hql);
		UtilQuery.setValues(countQuery, values);
		List<?> list = countQuery.list();
		long total = 0;
		if (list != null && list.size() > 0) {
			total = Long.parseLong(list.get(0).toString());
		}
		page.setTotal(total);
		if (total > 0) {
			Query query = getSession().createQuery(hql);
			UtilQuery.setValues(query, values);
			query.setFirstResult(page.getOffset());
			query.setMaxResults(page.getPageSize());
			page.setRows(query.list());
			logger.debug("总记录数：" + total + "，当前页：" + page.getPageNumber() + "，本页条数：" + page.getRows().size());
		} else {
			logger.debug("没有找到匹配的记录");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void pageH(Page<?> page, String hql, Map<String, Object> params) {
		Assert.notNull(page);
		Query countQuery = getSession().createQuery(UtilQuery.getCountQuery(hql));
		UtilQuery.setValues(countQuery, params);
		List<?> list = countQuery.list();
		long total = 0;
		if (list != null && list.size() > 0) {
			total = Long.parseLong(list.get(0).toString());
		}
		page.setTotal(total);
		if (total > 0) {
			Query query = getSession().createQuery(hql);
			UtilQuery.setValues(query, params);
			query.setFirstResult(page.getOffset());
			query.setMaxResults(page.getPageSize());
			page.setRows(query.list());
			logger.debug("总记录数：" + total + "，当前页：" + page.getPageNumber() + "，本页条数：" + page.getRows().size());
		} else {
			logger.debug("没有找到匹配的记录");
		}
	}

}
