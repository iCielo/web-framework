/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:56:51</p>
 */
package com.lezic.app.sys.user.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lezic.app.sys.user.entity.SysUser;
import com.lezic.app.sys.user.service.SysUserService;
import com.lezic.core.web.action.BaseController;
import com.lezic.core.web.constant.Status;

/**
 * @author cielo
 *
 */
@Controller
@RequestMapping("/sys")
public class SysUserController extends BaseController {
	
	@Autowired
	private SysUserService sysUserService;

	/**
	 * 列表页面
	 * @param model
	 * @return
	 * @author cielo
	 */
	@RequestMapping(value = "/users/listPage", method = RequestMethod.GET)
	public String listPage(Model model) {
		model.addAttribute("test", "test");
		return "/sys/user/listPage";
	}

	/**
	 * 新增页面
	 */
	@RequestMapping(value = "/user/addPage", method = RequestMethod.GET)
	public String addPage(Model model) {
		model.addAttribute("test", "test");
		return "/sys/user/addPage";
	}

	/**
	 * 修改页面
	 */
	@RequestMapping(value = "/user/updPage/{userId}", method = RequestMethod.GET)
	public String updPage(Model model) {
		model.addAttribute("test", "test");
		return "/sys/user/updPage";
	}
	
	/**
	 * 新增
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void addEntity() {

	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
	public void updEntity() {

	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
	public void delEntity(@PathVariable String userId) {

	}

}
