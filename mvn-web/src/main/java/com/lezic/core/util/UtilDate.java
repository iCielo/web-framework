/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午4:13:42</p>
 */
package com.lezic.core.util;

import java.util.UUID;

/**
 * 
 * 日期工具类
 * 
 * @author cielo
 *
 */
public class UtilDate {

	/** 格式：yyyy-MM-dd */
	public static final String P_YYYYMMDD = "yyyy-MM-dd";
	
	/** 格式：yyyyMMdd */
	public static final String P_YYYYMMDD_2 = "yyyyMMdd";
	
	/** 格式：yyyy-MM-dd HH:mm:ss */
	public static final String P_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

	public static void main(String[] args) {
		System.out.println(UUID.fromString(UUID.randomUUID().toString()));
		System.out.println(UUID.randomUUID());
	}
}
