/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	Mon Mar 14 13:59:24 CST 2016</p>
 */
package com.lezic.app.sys.resource.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lezic.app.sys.resource.entity.SysResource;
import com.lezic.app.sys.resource.service.SysResourceService;
import com.lezic.core.lang.ParamMap;
import com.lezic.core.orm.Page;
import com.lezic.core.orm.util.UtilHibernate;
import com.lezic.core.util.UtilData;
import com.lezic.core.web.action.BaseController;
import com.lezic.core.web.constant.Status;

/**
 * @author cielo
 *
 */
@Controller
@RequestMapping("/sys/resource.do")
public class SysResourceController extends BaseController {

	private Logger logger = LogManager.getLogger();

	@Autowired
	private SysResourceService sysResourceService;

	/**
	 * 列表页面
	 * 
	 * @param model
	 * @return
	 * @author cielo
	 */
	@RequestMapping(params = "method=list", method = RequestMethod.GET)
	public String listPage() {
		return "/sys/resource/SysResource-list";
	}

	/**
	 * 新增页面
	 */
	@RequestMapping(params = "method=add", method = RequestMethod.GET)
	public String addPage() {
		return "/sys/resource/SysResource-add";
	}

	/**
	 * 修改页面
	 */
	@RequestMapping(params = "method=upd", method = RequestMethod.GET)
	public String updPage(Model model) {
		String id = this.getParam("id");
		if (UtilData.isNotNull(id)) {
			model.addAttribute("entity", sysResourceService.getH(id));
		}
		return "/sys/resource/SysResource-upd";
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
	public void loadData(@ModelAttribute SysResource entityParams) throws IOException {
		Page<SysResource> page = new Page<SysResource>();
		page.setOffset(UtilData.integerOfString(this.getParam("offset"), 0));
		page.setPageSize(UtilData.integerOfString(this.getParam("limit"), 10));
		ParamMap params = new ParamMap();
		sysResourceService.pageM(page, "SysResource.getPageList", params);
		this.outBootstrapTable(page);
	}

	/**
	 * 新增
	 * 
	 * @throws IOException
	 */
	@RequestMapping(params = "method=addEntity")
	public void addEntity(@ModelAttribute SysResource entity) throws IOException {
		sysResourceService.saveH(entity);
		this.outMsg(Status.SUCCESS, null);
	}

	/**
	 * 修改
	 * 
	 * @throws IOException
	 */
	@RequestMapping(params = "method=updEntity")
	public void updEntity(@ModelAttribute SysResource item) throws IOException {
		if (item != null) {
			SysResource entity = sysResourceService.getH(item.getCode());
			UtilHibernate.copyExcludeNull(entity, item);
			sysResourceService.updH(entity);
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
		sysResourceService.batchDelH(SysResource.class, ids);
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
		String hql = "from SysResource where  (id != ? or ? is null) and account = ?";
		boolean isRepeat = sysResourceService.isExist(hql, id, id, account);
		Map<String, String> ret = new HashMap<String, String>();
		if (isRepeat) {
			ret.put("error", "对不起，已存在该账号！");
		} else {
			ret.put("ok", "该账号可用！");
		}
		this.write(ret);
	}

}
