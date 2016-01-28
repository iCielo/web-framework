/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	Thu Jan 28 18:26:36 CST 2016</p>
 */
package com.lezic.app.sys.role.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lezic.app.sys.role.entity.SysRole;
import com.lezic.app.sys.role.service.SysRoleService;
import com.lezic.core.lang.ParamMap;
import com.lezic.core.orm.Page;
import com.lezic.core.util.UtilData;
import com.lezic.core.web.action.BaseController;
import com.lezic.core.web.constant.Status;

/**
 * @author cielo
 *
 */
@Controller
@RequestMapping("/sys/role.do")
public class SysRoleController extends BaseController {

	private Logger logger = LogManager.getLogger();

	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 列表页面
	 * 
	 * @param model
	 * @return
	 * @author cielo
	 */
	@RequestMapping(params = "method=list", method = RequestMethod.GET)
	public String listPage() {
		return "/sys/role/SysRole-list";
	}

	/**
	 * 新增页面
	 */
	@RequestMapping(params = "method=add", method = RequestMethod.GET)
	public String addPage() {
		return "/sys/role/SysRole-add";
	}

	/**
	 * 修改页面
	 */
	@RequestMapping(params = "method=upd", method = RequestMethod.GET)
	public String updPage(Model model) {
		String id = this.getParam("id");
		if (UtilData.isNotNull(id)) {
			model.addAttribute("entity", sysRoleService.getH(id));
		}
		return "/sys/role/SysRole-upd";
	}

	/**
	 * 列表页面
	 * 
	 * @param model
	 * @return
	 * @author cielo
	 * @throws IOException
	 */
	@RequestMapping(params = "method=loadData", method = RequestMethod.GET)
	public void loadData() throws IOException {
		Page<SysRole> page = new Page<SysRole>();
		page.setOffset(UtilData.integerOfString(this.getParam("offset"), 0));
		page.setPageSize(UtilData.integerOfString(this.getParam("limit"), 10));
		String hql = "from SysRole";
		ParamMap params = new ParamMap();
		sysRoleService.pageH(page, hql, params);
		this.outBootstrapTable(page);
	}

	/**
	 * 新增
	 * 
	 * @throws IOException
	 */
	@RequestMapping(params = "method=addEntity")
	public void addEntity(@ModelAttribute SysRole entity) throws IOException {
		if (entity != null) {
			entity.setId(UUID.randomUUID().toString());
		}
		sysRoleService.saveH(entity);
		this.outMsg(Status.SUCCESS, null);
	}

	/**
	 * 修改
	 * 
	 * @throws IOException
	 */
	@RequestMapping(params = "method=updEntity")
	public void updEntity(@ModelAttribute SysRole entity) throws IOException {
		if (entity != null) {
			sysRoleService.updH(entity);
		}
		this.outMsg(Status.SUCCESS, null);
	}

	/**
	 * 删除
	 * 
	 * @throws IOException
	 */
	@RequestMapping(params = "method=delEntity")
	public void delEntity() throws IOException {
		String[] ids = UtilData.split(this.getParam("ids"), ",");
		sysRoleService.batchDelH(SysRole.class, ids);
		this.outMsg(Status.SUCCESS, null);
	}

	/**
	 * 判断名称是否重复
	 * 
	 * @throws IOException
	 * @author cielo
	 */
	@RequestMapping(params = "method=isRepeat")
	public void isRepeat() throws IOException {
		String id = this.getParam("id");
		String account = this.getParam("account");
		String hql = "from SysRole where  (id != ? or ? is null) and account = ?";
		boolean isRepeat = sysRoleService.isExist(hql, id, id, account);

		Map<String, String> ret = new HashMap<String, String>();
		if (isRepeat) {
			ret.put("error", "对不起，已存在该账号！");
		} else {
			ret.put("ok", "该账号可用！");
		}
		this.write(ret);
	}

}
