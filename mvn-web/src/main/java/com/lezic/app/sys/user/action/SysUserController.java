/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:56:51</p>
 */
package com.lezic.app.sys.user.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/sys")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService sysUserService;

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

	/**
	 * 查找单个实例
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public void getEntity(@PathVariable String userId) throws IOException {
		Integer id = Integer.parseInt(userId);
		SysUser sysUser = sysUserService.getH(id);
		this.outData(Status.SUCCESS, sysUser);
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
	@RequestMapping(value = "/users/search", method = RequestMethod.GET)
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

	
}
