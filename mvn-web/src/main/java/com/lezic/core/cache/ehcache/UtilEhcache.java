/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午2:12:19</p>
 */
package com.lezic.core.cache.ehcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.lezic.core.util.UtilData;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * Ehcache缓存工具类
 * 
 * @author cielo
 *
 */
@Component
public class UtilEhcache{

	private  CacheManager cacheManager;

	@Autowired
	public UtilEhcache(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
	
	
	/**
	 * 获取缓存 不存在时，创建
	 * 
	 * @param cacheName
	 *            缓存名
	 * @return
	 * @author cielo
	 */
	public  Ehcache getCache(String cacheName) {
		Assert.isTrue(UtilData.isNotNull(cacheName));
		if (!cacheManager.cacheExists(cacheName)) {
			cacheManager.addCache(cacheName);
		}
		return cacheManager.getEhcache(cacheName);
	}

	/**
	 * 查找值
	 * 
	 * @param cacheName
	 * @param key
	 * @return
	 * @author cielo
	 */
	public  Object getValue(String cacheName, String key) {
		Assert.isTrue(UtilData.isNotNull(cacheName));
		Assert.notNull(key);
		Ehcache cache = this.getCache(cacheName);
		Element element = cache.get(key);
		return element == null ? null : element.getObjectValue();
	}

	/**
	 * 新增缓存键值对对象
	 * 
	 * @param cacheName
	 *            缓存名
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @author cielo
	 */
	public  void update(String cacheName, Object key, Object value) {
		Assert.isTrue(UtilData.isNotNull(cacheName));
		Assert.notNull(key);
		Assert.notNull(value);
		Ehcache cache = this.getCache(cacheName);
		cache.put(new Element(key, value), true);
	}

	/**
	 * 删除缓存键值对对象
	 * 
	 * @param cacheName
	 *            缓存名
	 * @param key
	 *            键
	 * @author cielo
	 */
	public  void remove(String cacheName, Object key) {
		Assert.isTrue(UtilData.isNotNull(cacheName));
		Assert.notNull(key);
		Ehcache cache = this.getCache(cacheName);
		cache.remove(key);
	}


}
