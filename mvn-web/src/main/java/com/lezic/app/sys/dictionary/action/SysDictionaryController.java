/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	Wed Feb 24 11:00:01 CST 2016</p>
 */
package com.lezic.app.sys.dictionary.action;

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

import com.lezic.app.cache.SystemCache;
import com.lezic.app.sys.dictionary.entity.SysDictionary;
import com.lezic.app.sys.dictionary.service.SysDictionaryService;
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
@RequestMapping("/sys/dictionary.do")
public class SysDictionaryController extends BaseController {

	private Logger logger = LogManager.getLogger();

	@Autowired
	private SysDictionaryService sysDictionaryService;

	/**
	 * 列表页面
	 * 
	 * @param model
	 * @return
	 * @author cielo
	 */
	@RequestMapping(params = "method=list", method = RequestMethod.GET)
	public String listPage() {
		return "/sys/dictionary/SysDictionary-list";
	}

	/**
	 * 新增页面
	 */
	@RequestMapping(params = "method=add", method = RequestMethod.GET)
	public String addPage() {
		return "/sys/dictionary/SysDictionary-add";
	}

	/**
	 * 修改页面
	 */
	@RequestMapping(params = "method=upd", method = RequestMethod.GET)
	public String updPage(Model model) {
		String id = this.getParam("id");
		if (UtilData.isNotNull(id)) {
			model.addAttribute("entity", sysDictionaryService.getH(id));
		}
		return "/sys/dictionary/SysDictionary-upd";
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
		Page<SysDictionary> page = new Page<SysDictionary>();
		page.setOffset(UtilData.integerOfString(this.getParam("offset"), 0));
		page.setPageSize(UtilData.integerOfString(this.getParam("limit"), 10));
		String hql = "from SysDictionary order by sort,seq";
		ParamMap params = new ParamMap();
		sysDictionaryService.pageH(page, hql, params);
		this.outBootstrapTable(page);
	}

	/**
	 * 新增
	 * 
	 * @throws IOException
	 */
	@RequestMapping(params = "method=addEntity")
	public void addEntity(@ModelAttribute SysDictionary entity) throws IOException {
		if (entity != null) {
			entity.setId(UUID.randomUUID().toString());
		}
		sysDictionaryService.saveH(entity);
		this.outMsg(Status.SUCCESS, null);
	}

	/**
	 * 修改
	 * 
	 * @throws IOException
	 */
	@RequestMapping(params = "method=updEntity")
	public void updEntity(@ModelAttribute SysDictionary item) throws IOException {
		if (item != null) {
			SysDictionary entity = sysDictionaryService.getH(item.getId());
			UtilHibernate.copyExcludeNull(entity, item);
			sysDictionaryService.updH(entity);
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
		sysDictionaryService.batchDelH(SysDictionary.class, ids);
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
		String sort = this.getParam("sort");
		String dictKey = this.getParam("dictKey");
		String hql = "from SysDictionary where  (id != ? or ? is null) and sort = ? and (dictKey = ? or ? is null)";
		boolean isRepeat = sysDictionaryService.isExist(hql, id, id, sort, dictKey, dictKey);
		Map<String, String> ret = new HashMap<String, String>();
		if (isRepeat) {
			ret.put("error", "对不起，已存在该字典！");
		} else {
			ret.put("ok", "该字典可用！");
		}
		this.write(ret);
	}
	
	/**
	 * 启用、禁用
	 * 
	 * @throws IOException
	 * @author cielo
	 */
	@RequestMapping(params = "method=opStatus")
	public void opStatus() throws IOException {
		String[] ids = UtilData.split(this.getParam("ids"), ",");
		String status = this.getParam("status");
		if (UtilData.isEmpty(ids)) {
			this.outMsg(Status.FAIL, "要操作记录ID为空！");
		} else if (UtilData.isNull(status)) {
			this.outMsg(Status.FAIL, "操作类型为空！");
		} else {
			ParamMap params = new ParamMap();
			String hql = "update SysDictionary set status = :status where id in (:ids)";
			params.put("status", status);
			params.put("ids", ids);
			sysDictionaryService.executeH(hql, params);
			String msg = SystemCache.getSysDictionaryLabel("STATUS", status) + "成功！";
			this.outMsg(Status.SUCCESS, msg);
		}
	}

}
