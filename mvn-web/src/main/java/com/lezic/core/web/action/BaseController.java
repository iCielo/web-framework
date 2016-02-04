/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 下午1:52:24</p>
 */
package com.lezic.core.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.lezic.core.orm.Page;
import com.lezic.core.util.UtilData;
import com.lezic.core.web.constant.Status;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 控制器基类
 * 
 * @author cielo
 *
 */
public abstract class BaseController {

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession session;

	private Logger logger = LogManager.getLogger(BaseController.class);

	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	/**
	 * 获取表单参数
	 * 
	 * @param name
	 * @return
	 * @author cielo
	 */
	public String getParam(String name) {
		String str = UtilData.trim(this.request.getParameter(name));
		if(UtilData.isNull(str)){
			return null;
		}
		return str;
	}

	/**
	 * 将指定对象转为ajax字符串写入response
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void write(Object object){
		response.setContentType("application/json;charset=UTF-8");
		// response.setContentType("text/xml;charset=UTF-8");
		try {
			if (object instanceof Collection) {
				JSONArray jsonArray = JSONArray.fromObject(object);
				response.getWriter().write(jsonArray.toString());
			} else {
				JSONObject jsonObject = JSONObject.fromObject(object);
				response.getWriter().write(jsonObject.toString());
			}
		} catch (Exception e) {
			logger.error("系统错误！", e);
		}
	}

	/**
	 * 输出ajax的返回值
	 * 
	 * @param status
	 * @param msg
	 * @throws IOException
	 * @author cielo
	 */
	public void outMsg(Status status, String msg){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", status);
		map.put("msg", msg);
		this.write(map);
	}

	/**
	 * 输出ajax的返回值
	 * 
	 * @param status
	 * @param data
	 * @throws IOException
	 * @author cielo
	 */
	public void outData(Status status, Object data){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", status);
		map.put("data", data);
		this.write(map);
	}

	/**
	 * 输出bootstrap table的数据
	 * 
	 * @param page
	 * @throws IOException
	 * @author cielo
	 */
	public void outBootstrapTable(Page<?> page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(UtilData.isEmpty(page.getRows())){
			map.put("rows", new ArrayList<Object>());	
		}else{
			map.put("rows", page.getRows());
		}
		
		map.put("total", page.getTotal());
		this.write(map);
	}

}
