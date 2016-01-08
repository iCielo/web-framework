package com.lezic.core.web.action;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * CRUD基类
 * 
 * 
 * 
 * @author cielo
 *
 */
@RestController
@RequestMapping("/模块分类名")
public abstract class CrudController extends BaseController {

	/**
	 * 新增
	 */
	@RequestMapping(value = "/模块名", method = RequestMethod.POST)
	public abstract void addEntity();

	/**
	 * 修改
	 */
	@RequestMapping(value = "/模块名/{id}", method = RequestMethod.PUT)
	public abstract void updEntity(@PathVariable String id);

	/**
	 * 删除
	 */
	@RequestMapping(value = "/模块名/{id}", method = RequestMethod.DELETE)
	public abstract void delEntity(@PathVariable String id);

}
