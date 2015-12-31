/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 下午1:52:24</p>
 */
package com.lezic.core.web.action;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

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

	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}
	
	/**
	 * 将指定对象转为ajax字符串写入response
	 * @param object
	 * @throws IOException
	 */
    public void write(Object object) throws IOException {
        response.setContentType("text/xml;charset=UTF-8");
        if (object instanceof Collection) {
            JSONArray jsonArray = JSONArray.fromObject(object);
            response.getWriter().write(jsonArray.toString());
        } else {
            JSONObject jsonObject = JSONObject.fromObject(object);
            response.getWriter().write(jsonObject.toString());
        }
    }
}
