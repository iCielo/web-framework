/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 上午10:14:06</p>
 */
package com.lezic.core.web.handle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.lezic.core.util.UtilJson;
import com.lezic.core.web.constant.Status;

/**
 * @author cielo
 *
 */
@Component
public class BaseHandleExceptionResolver implements HandlerExceptionResolver {

	private Logger logger = LogManager.getLogger(getClass());

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		if (ex != null) {
			String ajax = request.getParameter("ajax");
			String msg = ex.getMessage();
			logger.error("系统错误！", ex);
			if ("true".equals(ajax)) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("status", Status.ERROR);
				map.put("msg", msg);
				response.setContentType("application/json");
				try {
					response.getWriter().write(UtilJson.toString(map));
				} catch (IOException e) {
				}
			} else {
				request.setAttribute("status", Status.ERROR);
				request.setAttribute("msg", msg);
				return new ModelAndView("main/exception");
			}
		}
		return null;
	}
}
