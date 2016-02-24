/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午2:09:36</p>
 */
package com.lezic.app.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.lezic.app.sys.dictionary.entity.SysDictionary;

/**
 * 系统级缓存
 * 
 * @author cielo
 *
 */
public class SystemCache {

	/**
	 * 数据字典缓存 MAP<id,SysDictionary>
	 */
	public static Map<String, SysDictionary> DICT_ID_MAP = new ConcurrentHashMap<String, SysDictionary>();

	/**
	 * 数据字典缓存 MAP<sort+"-"+dictKey,SysDictionary>
	 */
	public static Map<String, SysDictionary> DICT_KEY_MAP = new ConcurrentHashMap<String, SysDictionary>();

	/**
	 * 数据字典缓存 MAP<sort,List<SysDictionary>>
	 */
	public static Map<String, List<SysDictionary>> DICT_SORT_MAP = new ConcurrentHashMap<String, List<SysDictionary>>();

	/**
	 * 获取数据字典
	 * 
	 * @param sort
	 * @param key
	 * @return
	 * @author cielo
	 */
	public static SysDictionary getSysDictionary(String sort, String key) {
		return DICT_KEY_MAP.get(sort + "-" + key);
	}

	/**
	 * 获取数据字典
	 * 
	 * @param sort
	 * @param key
	 * @return
	 * @author cielo
	 */
	public static String getSysDictionaryLabel(String sort, String key) {
		SysDictionary item = getSysDictionary(sort, key);
		return item == null ? null : item.getDictValue();
	}

}
