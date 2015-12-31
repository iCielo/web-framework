package com.lezic.app.sys.user.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lezic.core.web.action.BaseController;

@Controller
@RequestMapping("/sys")
public class UserController extends BaseController{

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
	public void delEntity() {

	}

	/**
	 * 查找单个实例
	 */
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public void getEntity() {

	}

	/**
	 * 获取所有实例
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public void getAllEntity() {

	}

	/**
	 * 条件查找
	 * 
	 * @param name
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public void searchEntity(@RequestParam(value = "name", required = false) String name) {

	}
	
	
	

	/**
	 * 获取一个新用户。初始化默认值
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public void getUser() {

	}

	/**
	 * 根据角色名查找所有该角色的用户
	 * 
	 * @param userName
	 */
	@RequestMapping(value = "/users/searchByRoles", method = RequestMethod.GET)
	public void searchByRoles(@RequestParam(value = "name", required = false) String name) {

	}

	/**
	 * 查找指定用户下的所有菜单资源
	 * 
	 * @param userName
	 */
	@RequestMapping(value = "/user/${userId}/menus", method = RequestMethod.GET)
	public void getUserMenus() {

	}
}
