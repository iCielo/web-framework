/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 上午10:39:12</p>
 */
package com.lezic.core.util;

import java.util.Collection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author cielo
 *
 */
public class UtilJson {

	/**
	 * 对象转JSON字符串
	 * 
	 * @param object
	 *            类对象或对象集合
	 * @return
	 * @author cielo
	 */
	public static String toString(Object object) {
		if (object instanceof Collection) {
			JSONArray jsonArray = JSONArray.fromObject(object);
			return jsonArray.toString();
		} else {
			JSONObject jsonObject = JSONObject.fromObject(object);
			return jsonObject.toString();
		}
	}
}
