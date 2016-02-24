/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	Wed Feb 24 11:00:01 CST 2016</p>
 */
package com.lezic.app.sys.dictionary.service;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lezic.app.cache.SystemCache;
import com.lezic.app.sys.dictionary.entity.SysDictionary;
import com.lezic.core.orm.service.BaseService;

/**
 * 数据字典服务类
 * 
 * @author cielo
 *
 */
@Service
@Transactional
public class SysDictionaryService extends BaseService<SysDictionary> {

	private Logger logger = LogManager.getLogger(getClass());

	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
	}

	/**
	 * 初始化缓存
	 * 
	 * @author cielo
	 */
	@SuppressWarnings("unchecked")
	public void initCache() {
		SystemCache.DICT_SORT_MAP.clear();
		SystemCache.DICT_ID_MAP.clear();
		SystemCache.DICT_KEY_MAP.clear();
		logger.info("加载数据字典缓存......BEGIN");
		List<SysDictionary> list = (List<SysDictionary>) this
				.findH("from SysDictionary where status = 'ON' order by seq");
		for (Iterator<SysDictionary> iterator = list.iterator(); iterator.hasNext();) {
			SysDictionary item = iterator.next();
			logger.info(item.toString());
			List<SysDictionary> sortList = SystemCache.DICT_SORT_MAP.get(item.getSort());
			if (sortList == null) {
				sortList = new LinkedList<SysDictionary>();
				SystemCache.DICT_SORT_MAP.put(item.getSort(), sortList);
			}
			sortList.add(item);
			SystemCache.DICT_ID_MAP.put(item.getId(), item);
			SystemCache.DICT_KEY_MAP.put(item.getSort() + "-" + item.getDictKey(), item);
		}
		logger.info("加载数据字典缓存......END");
	}

	@Override
	public Serializable saveH(SysDictionary entity) {
		Serializable id = super.saveH(entity);
		initCache();
		return id;
	}

	@Override
	public void updH(SysDictionary entity) {
		super.updH(entity);
	}

	@Override
	public void delH(SysDictionary entity) {
		super.delH(entity);
		initCache();
	}

	@Override
	public int batchDelH(Class<?> cl, Serializable[] ids) {
		int result = super.batchDelH(cl, ids);
		initCache();
		return result;
	}

	@Override
	public void saveOrUpdH(SysDictionary entity) {
		super.saveOrUpdH(entity);
		initCache();
	}

}
