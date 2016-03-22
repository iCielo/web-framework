package com.lezic.app.sys.resource.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统资源
 * 
 * @author cielo
 * @date Mon Mar 14 13:59:24 CST 2016
 */
@Entity
@Table(name = "sys_resource")
public class SysResource implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 资源名称
	 */
	@Column(name = "name", length = 255, unique = true)
	private String name;

	/**
	 * 操作时间
	 */
	@Column(name = "op_time", unique = true)
	private Date opTime;

	/**
	 * 操作用户ID
	 */
	@Column(name = "op_user_id", length = 36, unique = true)
	private String opUserId;

	/**
	 * 资源链接地址
	 */
	@Column(name = "url", length = 255, unique = true)
	private String url;

	/**
	 * 资源码
	 */
	@Id
	@Column(name = "code", length = 255, unique = true, nullable = false)
	private String code;

	/**
	 * 父资源
	 */
	@Column(name = "parent_code", length = 255, unique = true)
	private String parentCode;

	/**
	 * 类型 1：菜单 2：功能码
	 */
	@Column(name = "type", unique = true)
	private Integer type;

	/**
	 * 设置 资源名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取 资源名称
	 */
	public String getName() {
		return this.name;
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
	 * 设置 操作用户ID
	 */
	public void setOpUserId(String opUserId) {
		this.opUserId = opUserId;
	}

	/**
	 * 获取 操作用户ID
	 */
	public String getOpUserId() {
		return this.opUserId;
	}

	/**
	 * 设置 资源链接地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取 资源链接地址
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * 设置 资源码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取 资源码
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * 设置 父资源
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	/**
	 * 获取 父资源
	 */
	public String getParentCode() {
		return this.parentCode;
	}

	/**
	 * 设置 类型 1：菜单 2：功能码
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取 类型 1：菜单 2：功能码
	 */
	public Integer getType() {
		return this.type;
	}

	@Override
	public String toString() {
		return "SysResource [" + "name=" + name + ", " + "opTime=" + opTime + ", " + "opUserId=" + opUserId + ", "
				+ "url=" + url + ", " + "code=" + code + ", " + "parentCode=" + parentCode + ", " + "type=" + type
				+ "]";
	}

}
