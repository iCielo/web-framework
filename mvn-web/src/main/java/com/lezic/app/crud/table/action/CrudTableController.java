/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:53:45</p>
 */
package com.lezic.app.crud.table.action;

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

import com.lezic.app.crud.table.entity.CrudTable;
import com.lezic.app.crud.table.service.CrudTableService;
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
@RequestMapping("/crud/table.do")
public class CrudTableController extends BaseController {

	private Logger logger = LogManager.getLogger();

	@Autowired
	private CrudTableService crudTableService;

	/**
	 * 列表页面
	 * 
	 * @param model
	 * @return
	 * @author cielo
	 */
	@RequestMapping(params = "method=list", method = RequestMethod.GET)
	public String listPage(Model model) {
		return "/crud/table/CrudTable-list";
	}

	/**
	 * 新增页面
	 */
	@RequestMapping(params = "method=add", method = RequestMethod.GET)
	public String addPage() {
		return "/crud/table/CrudTable-add";
	}

	/**
	 * 修改页面
	 */
	@RequestMapping(params = "method=upd", method = RequestMethod.GET)
	public String updPage(Model model) {
		String id = this.getParam("id");
		if (UtilData.isNotNull(id)) {
			model.addAttribute("entity", crudTableService.getH(id));
		}
		return "/crud/table/CrudTable-upd";
	}

	/**
	 * 列表页面
	 * 
	 * @param model
	 * @return
	 * @author cielo
	 */
	@RequestMapping(params = "method=loadData", method = RequestMethod.GET)
	public void loadData() {
		Page<CrudTable> page = new Page<CrudTable>();
		page.setOffset(UtilData.integerOfString(this.getParam("offset"), 0));
		page.setPageSize(UtilData.integerOfString(this.getParam("limit"), 10));
		String hql = "from CrudTable order by moduleName";
		ParamMap params = new ParamMap();
		crudTableService.pageH(page, hql, params);
		this.outBootstrapTable(page);
	}

	/**
	 * 新增
	 * 
	 */
	@RequestMapping(params = "method=addEntity")
	public void addEntity(@ModelAttribute CrudTable entity) {
		crudTableService.addEntity(entity);
		this.outMsg(Status.SUCCESS, null);
	}

	/**
	 * 修改
	 * 
	 */
	@RequestMapping(params = "method=updEntity")
	public void updEntity(@ModelAttribute CrudTable entity) {
		if (entity != null) {
			crudTableService.updEntity(entity);
		}
		this.outMsg(Status.SUCCESS, null);
	}

	/**
	 * 删除
	 * 
	 */
	@RequestMapping(params = "method=delEntity")
	public void delEntity() {
		String[] ids = UtilData.split(this.getParam("ids"), ",");
		crudTableService.batchDelH(CrudTable.class, ids);
		this.outMsg(Status.SUCCESS, null);
	}

	/**
	 * 判断名称是否重复
	 * 
	 * @author cielo
	 */
	@RequestMapping(params = "method=isRepeat")
	public void isRepeat() {
		String id = this.getParam("id");
		String tableName = this.getParam("tableName");
		Map<String, String> ret = new HashMap<String, String>();
		boolean isExist = crudTableService.isTableExist(tableName);
		if (!isExist) {
			ret.put("error", "对不起，表不存在！");
		} else {
			String hql = "from CrudTable where  (id != ? or ? is null) and tableName = ?";
			boolean isRepeat = crudTableService.isExist(hql, id, id, tableName);
			if (isRepeat) {
				ret.put("error", "对不起，该表已生成代码！");
			} else {
				ret.put("ok", "验证通过！");
			}
		}
		this.write(ret);
	}
	
	/**
	 * 更新表字段
	 * 
	 * @author cielo
	 */
	@RequestMapping(params = "method=updateColumns")
	public void updateColumns() {
		try {
			String tableName = this.getParam("tableName");
			if (UtilData.isNull(tableName)) {
				this.outMsg(Status.FAIL, "表名为空！");
				return;
			}
			crudTableService.updateColumns(tableName);
			this.outMsg(Status.SUCCESS, "更新表字段成功！");
		} catch (Exception e) {
			this.outMsg(Status.ERROR, "运行出现错误！");
		}
	}

	/**
	 * 生成代码
	 * 
	 * @author cielo
	 */
	@RequestMapping(params = "method=processCode")
	public void processCode() {
		try {
			String tableName = this.getParam("tableName");
			if (UtilData.isNull(tableName)) {
				this.outMsg(Status.FAIL, "表名为空！");
				return;
			}
			crudTableService.processCode(tableName);
			this.outMsg(Status.SUCCESS, "生成成功！");
		} catch (Exception e) {
			this.outMsg(Status.ERROR, "运行出现错误！");
		}
	}

}