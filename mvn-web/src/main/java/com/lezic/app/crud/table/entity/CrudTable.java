package com.lezic.app.crud.table.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 数据库表
 * 
 * @author cielo
 * @date Mon Feb 22 14:15:05 CST 2016
 */
@Entity
@Table(name = "crud_table")
public class CrudTable implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 操作用户
	 */
	@Column(name = "OP_USER_ID", length = 36)
	private String opUserId;

	/**
	 * 控制器包路径
	 */
	@Column(name = "CONTROLLER_PACKAGE", length = 255, nullable = false)
	private String controllerPackage;

	/**
	 * 控制器类
	 */
	@Column(name = "CONTROLLER", length = 255, nullable = false)
	private String controller;

	/**
	 * 新增映射
	 */
	@Column(name = "ADD_URL", length = 255, nullable = false)
	private String addUrl;

	/**
	 * 修改JSP
	 */
	@Column(name = "UPD_JSP", length = 255, nullable = false)
	private String updJsp;

	/**
	 * 模块代码
	 */
	@Column(name = "MODULE_CODE", length = 20, nullable = false)
	private String moduleCode;

	/**
	 * 修改映射
	 */
	@Column(name = "UPD_URL", length = 255, nullable = false)
	private String updUrl;

	/**
	 * 实体类包路径
	 */
	@Column(name = "ENTITY_PACKAGE", length = 255, nullable = false)
	private String entityPackage;

	/**
	 * 控制器类作为bean的名称
	 */
	@Column(name = "CONTROLLER_BEAN", length = 255)
	private String controllerBean;

	/**
	 * 列表JSP
	 */
	@Column(name = "LIST_JSP", length = 255, nullable = false)
	private String listJsp;

	/**
	 * 表名
	 */
	@Column(name = "TABLE_NAME", length = 20, nullable = false)
	private String tableName;

	/**
	 * mybatis的xml配置
	 */
	@Column(name = "MYBATIS_XML", length = 255, unique = true, nullable = false)
	private String mybatisXml;

	/**
	 * 服务层作为bean的名称
	 */
	@Column(name = "SERVICE_BEAN", length = 255)
	private String serviceBean;

	/**
	 * 实体类名
	 */
	@Column(name = "ENTITY", length = 255, nullable = false)
	private String entity;

	/**
	 * 模块名
	 */
	@Column(name = "MODULE_NAME", length = 50, nullable = false)
	private String moduleName;

	/**
	* 
	*/
	@Id
	@Column(name = "id", length = 36, unique = true, nullable = false)
	private String id;

	/**
	 * 操作时间
	 */
	@Column(name = "OP_TIME")
	private Date opTime;

	/**
	 * 服务层包路径
	 */
	@Column(name = "SERVICE_PACKAGE", length = 255, nullable = false)
	private String servicePackage;

	/**
	 * 列表映射
	 */
	@Column(name = "LIST_URL", length = 255, nullable = false)
	private String listUrl;

	/**
	 * 新增JSP
	 */
	@Column(name = "ADD_JSP", length = 255, nullable = false)
	private String addJsp;

	/**
	 * 服务层类
	 */
	@Column(name = "SERVICE", length = 255, nullable = false)
	private String service;

	/**
	 * 菜单名
	 */
	@Column(name = "MENU_NAME", length = 50, nullable = false)
	private String menuName;

	/**
	 * 控制器映射路径
	 */
	@Column(name = "CONTROLLER_URL", length = 255, nullable = false)
	private String controllerUrl;

	/**
	 * 实体类作为bean的名称
	 */
	@Column(name = "ENTITY_BEAN", length = 255)
	private String entityBean;

	/**
	 * 设置 操作用户
	 */
	public void setOpUserId(String opUserId) {
		this.opUserId = opUserId;
	}

	/**
	 * 获取 操作用户
	 */
	public String getOpUserId() {
		return this.opUserId;
	}

	/**
	 * 设置 控制器包路径
	 */
	public void setControllerPackage(String controllerPackage) {
		this.controllerPackage = controllerPackage;
	}

	/**
	 * 获取 控制器包路径
	 */
	public String getControllerPackage() {
		return this.controllerPackage;
	}

	/**
	 * 设置 控制器类
	 */
	public void setController(String controller) {
		this.controller = controller;
	}

	/**
	 * 获取 控制器类
	 */
	public String getController() {
		return this.controller;
	}

	/**
	 * 设置 新增映射
	 */
	public void setAddUrl(String addUrl) {
		this.addUrl = addUrl;
	}

	/**
	 * 获取 新增映射
	 */
	public String getAddUrl() {
		return this.addUrl;
	}

	/**
	 * 设置 修改JSP
	 */
	public void setUpdJsp(String updJsp) {
		this.updJsp = updJsp;
	}

	/**
	 * 获取 修改JSP
	 */
	public String getUpdJsp() {
		return this.updJsp;
	}

	/**
	 * 设置 模块代码
	 */
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	/**
	 * 获取 模块代码
	 */
	public String getModuleCode() {
		return this.moduleCode;
	}

	/**
	 * 设置 修改映射
	 */
	public void setUpdUrl(String updUrl) {
		this.updUrl = updUrl;
	}

	/**
	 * 获取 修改映射
	 */
	public String getUpdUrl() {
		return this.updUrl;
	}

	/**
	 * 设置 实体类包路径
	 */
	public void setEntityPackage(String entityPackage) {
		this.entityPackage = entityPackage;
	}

	/**
	 * 获取 实体类包路径
	 */
	public String getEntityPackage() {
		return this.entityPackage;
	}

	/**
	 * 设置 控制器类作为bean的名称
	 */
	public void setControllerBean(String controllerBean) {
		this.controllerBean = controllerBean;
	}

	/**
	 * 获取 控制器类作为bean的名称
	 */
	public String getControllerBean() {
		return this.controllerBean;
	}

	/**
	 * 设置 列表JSP
	 */
	public void setListJsp(String listJsp) {
		this.listJsp = listJsp;
	}

	/**
	 * 获取 列表JSP
	 */
	public String getListJsp() {
		return this.listJsp;
	}

	/**
	 * 设置 表名
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 获取 表名
	 */
	public String getTableName() {
		return this.tableName;
	}

	/**
	 * 设置 mybatis的xml配置
	 */
	public void setMybatisXml(String mybatisXml) {
		this.mybatisXml = mybatisXml;
	}

	/**
	 * 获取 mybatis的xml配置
	 */
	public String getMybatisXml() {
		return this.mybatisXml;
	}

	/**
	 * 设置 服务层作为bean的名称
	 */
	public void setServiceBean(String serviceBean) {
		this.serviceBean = serviceBean;
	}

	/**
	 * 获取 服务层作为bean的名称
	 */
	public String getServiceBean() {
		return this.serviceBean;
	}

	/**
	 * 设置 实体类名
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}

	/**
	 * 获取 实体类名
	 */
	public String getEntity() {
		return this.entity;
	}

	/**
	 * 设置 模块名
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * 获取 模块名
	 */
	public String getModuleName() {
		return this.moduleName;
	}

	/**
	 * 设置
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 设置 操作时间
	 */
	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}

	/**
	 * 获取 操作时间
	 */
	public Date getOpTime() {
		return this.opTime;
	}

	/**
	 * 设置 服务层包路径
	 */
	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}

	/**
	 * 获取 服务层包路径
	 */
	public String getServicePackage() {
		return this.servicePackage;
	}

	/**
	 * 设置 列表映射
	 */
	public void setListUrl(String listUrl) {
		this.listUrl = listUrl;
	}

	/**
	 * 获取 列表映射
	 */
	public String getListUrl() {
		return this.listUrl;
	}

	/**
	 * 设置 新增JSP
	 */
	public void setAddJsp(String addJsp) {
		this.addJsp = addJsp;
	}

	/**
	 * 获取 新增JSP
	 */
	public String getAddJsp() {
		return this.addJsp;
	}

	/**
	 * 设置 服务层类
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * 获取 服务层类
	 */
	public String getService() {
		return this.service;
	}

	/**
	 * 设置 菜单名
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * 获取 菜单名
	 */
	public String getMenuName() {
		return this.menuName;
	}

	/**
	 * 设置 控制器映射路径
	 */
	public void setControllerUrl(String controllerUrl) {
		this.controllerUrl = controllerUrl;
	}

	/**
	 * 获取 控制器映射路径
	 */
	public String getControllerUrl() {
		return this.controllerUrl;
	}

	/**
	 * 设置 实体类作为bean的名称
	 */
	public void setEntityBean(String entityBean) {
		this.entityBean = entityBean;
	}

	/**
	 * 获取 实体类作为bean的名称
	 */
	public String getEntityBean() {
		return this.entityBean;
	}

}
