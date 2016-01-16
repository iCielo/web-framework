/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午5:24:00</p>
 */
package com.lezic.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cielo
 *
 */
public class UtilRegex {
	
	public static final String MAIL = "^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";

	/**
	 * 返回匹配的字符串数组
	 * 
	 * @param s
	 * @param pattern
	 * @return
	 */
	public static List<String> match(String s, String pattern) {
		Matcher m = Pattern.compile(pattern).matcher(s);
		List<String> result = new ArrayList<String>();
		while (m.find()) {
			int num = m.groupCount();
			for (int i = 0; i <= num; i++) {
				result.add(m.group(i));
			}
		}
		return result;
	}

	/**
	 * 获取第一个匹配的结果
	 * 
	 * @param s
	 * @param pattern
	 * @param group
	 * @return
	 * @author cielo
	 */
	public static String matchFirst(String s, String pattern, int group) {
		try {
			Matcher m = Pattern.compile(pattern).matcher(s);
			while (m.find()) {
				return m.group(group);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取第一个匹配的结果
	 * 
	 * @param s
	 * @param pattern
	 * @param group
	 *            默认为0
	 * @return
	 * @author cielo
	 */
	public static String matchFirst(String s, String pattern) {
		return matchFirst(s, pattern, 0);
	}

	/**
	 * 验证是否正确
	 * 
	 * @param s
	 * @param pattern
	 * @return
	 * @author cielo
	 */
	public static boolean validator(String s, String pattern) {
		Matcher m = Pattern.compile(pattern).matcher(s);
		return m.find();
	}

	public static void main(String[] args) {
		// System.out.println(UtilRegex.matchFirst("530 Error: A secure connection is requiered(such as ssl). More
		// information at http://service.mail.qq.com/cgi-bin/help?id=28",
		// "\\d+"));
//		System.out.println(UtilRegex.matchFirst("cielo<lincl@nfky.com>;", "[^<]+", 0));
		
		String str = "select a.btype,a.userid,b.name userName,a.unread"
				+ "			from wb_user_remind a,wb_weibo_user b"
				+ "			where a.btype = b.btype and a.userid = b.userid"
				+ "			and a.op_userid = $opUserid"
				+ "			and a.real_id = :realId"
				+ "			#if($name)"
				+ "			and b.name like :name"
				+ "			#end"
				+ "			order"
				+ " by a.unread asc,   b.xx asc,d.xa , "
				+ "b.name Desc";
		
		String pattern = "(?i)\\s+order\\s+by\\s+[^)]+";
		String result = UtilRegex.matchFirst(str, pattern);
//		System.out.println(result);
		
		String regex = "(?i)\\s+order\\s+by\\s+[^)]+";
		String countHql =str.replaceAll(regex, "");
		countHql = "select count(1) from (" + countHql + ") a";
		System.out.println(countHql);
	}
}
