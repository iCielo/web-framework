package com.lezic.app.sys.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lezic.app.cache.SystemCache;

/**
 * 用户管理
 * 
 * @author cielo
 * @date Wed Feb 24 16:19:39 CST 2016
 */
@Entity
@Table(name = "sys_user")
public class SysUser implements java.io.Serializable {
	
	/**
	 * 性别label
	 * @return
	 * @author cielo
	 */
	public String getSexLabel(){
		return SystemCache.getSysDictionaryLabel("SEX", sex);
	}
	
	/*---------------------------------------------------------------*/

	private static final long serialVersionUID = 1L;
	/**
	 * uuid主键
	 */
	@Id
	@Column(name = "id", length = 36, nullable = false)
	private String id;

	/**
	 * 操作用户ID
	 */
	@Column(name = "op_user_id", length = 36)
	private String opUserId;

	/**
	 * 备注
	 */
	@Column(name = "remark", length = 255)
	private String remark;

	/**
	 * 性别
	 */
	@Column(name = "sex", length = 10)
	private String sex;

	/**
	 * 账号
	 */
	@Column(name = "account", length = 200, nullable = false)
	private String account;

	/**
	 * 操作时间
	 */
	@Column(name = "op_time")
	private Date opTime;

	/**
	 * 状态 on:启用 off:禁用
	 */
	@Column(name = "status", length = 20)
	private String status;

	/**
	 * 手机号码
	 */
	@Column(name = "phone", length = 100)
	private String phone;

	/**
	 * 邮箱地址
	 */
	@Column(name = "email", length = 100, nullable = false)
	private String email;

	/**
	 * 姓名
	 */
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	/**
	 * 密码
	 */
	@Column(name = "password", length = 200, nullable = false)
	private String password;

	/**
	 * 设置 uuid主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 uuid主键
	 */
	public String getId() {
		return this.id;
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
	 * 设置 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取 备注
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 设置 性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 获取 性别
	 */
	public String getSex() {
		return this.sex;
	}

	/**
	 * 设置 账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * 获取 账号
	 */
	public String getAccount() {
		return this.account;
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
	 * 设置 状态 on:启用 off:禁用
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取 状态 on:启用 off:禁用
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 设置 手机号码
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 获取 手机号码
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * 设置 邮箱地址
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取 邮箱地址
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * 设置 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取 姓名
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 设置 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取 密码
	 */
	public String getPassword() {
		return this.password;
	}

	@Override
	public String toString() {
		return "SysUser [" + "id=" + id + ", " + "opUserId=" + opUserId + ", " + "remark=" + remark + ", " + "sex="
				+ sex + ", " + "account=" + account + ", " + "opTime=" + opTime + ", " + "status=" + status + ", "
				+ "phone=" + phone + ", " + "email=" + email + ", " + "name=" + name + ", " + "password=" + password
				+ "]";
	}

}
