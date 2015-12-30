/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 下午1:44:52</p>
 */
package com.lezic.app.index.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lezic.core.web.action.BaseController;

/**
 * 首页
 * @author cielo
 *
 */
@Controller
@RequestMapping("/index")
public class IndexAction extends BaseController {

	@RequestMapping(method = RequestMethod.GET)
	public String initPage() {
		return "/index";
	}

}
