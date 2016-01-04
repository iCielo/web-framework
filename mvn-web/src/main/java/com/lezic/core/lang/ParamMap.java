/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午4:08:06</p>
 */
package com.lezic.core.lang;

import java.util.HashMap;

/**
 * 参数键值对
 * 
 * @author cielo
 *
 */
public class ParamMap extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	/**
	 * 若value为字符串，则自动去除前后空格
	 */
	@Override
	public Object put(String key, Object value) {
		if (value != null) {
			if (value instanceof String) {
				return super.put(key, ((String) value).trim());
			}
		}
		return super.put(key, value);
	}
}
