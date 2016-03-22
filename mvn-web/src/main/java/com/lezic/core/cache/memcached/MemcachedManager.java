/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午4:17:53</p>
 */
package com.lezic.core.cache.memcached;

import org.springframework.stereotype.Component;

import com.alisoft.xplatform.asf.cache.ICacheManager;
import com.alisoft.xplatform.asf.cache.IMemcachedCache;
import com.alisoft.xplatform.asf.cache.memcached.CacheUtil;
import com.alisoft.xplatform.asf.cache.memcached.MemcachedCacheManager;

/**
 * 基于alisoft的memcachedCache
 * 
 * @author cielo
 *
 */
@Component
public class MemcachedManager {

	private ICacheManager<IMemcachedCache> manager;

	private IMemcachedCache cache;

	public MemcachedManager() {
		manager = CacheUtil.getCacheManager(IMemcachedCache.class, MemcachedCacheManager.class.getName());
		manager.setConfigFile("memcached.xml");
		manager.setResponseStatInterval(5 * 1000);
		manager.start();
		cache = manager.getCache("mclient0");
	}

	/**
	 * 获取缓存接口
	 * 
	 * @return
	 */
	public IMemcachedCache getCache() {
		return cache;
	}

	/**
	 * 数据放入缓存
	 * 
	 * @param key
	 * @param object
	 */
	public void put(String key, Object object) {
		cache.put(key, object);
	}

	/**
	 * 从缓存中读取数据
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return cache.get(key);
	}

}
