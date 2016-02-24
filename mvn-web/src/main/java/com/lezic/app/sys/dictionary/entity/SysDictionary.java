package com.lezic.app.sys.dictionary.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 数据字典
 * 
 * @author cielo
 * @date Wed Feb 24 11:28:49 CST 2016
 */
@Entity
@Table(name = "sys_dictionary")
public class SysDictionary implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 排序值
	 */
	@Column(name = "seq", unique = true, nullable = false)
	private Integer seq;

	/**
	 * 状态：on，off
	 */
	@Column(name = "status", length = 50, unique = true, nullable = false)
	private String status;

	/**
	 * 操作用户
	 */
	@Column(name = "op_user_id", unique = true)
	private Integer opUserId;

	/**
	 * 操作时间
	 */
	@Column(name = "op_time", unique = true)
	private Date opTime;

	/**
	 * 字典键
	 */
	@Column(name = "dict_key", length = 255, unique = true, nullable = false)
	private String dictKey;

	/**
	 * 分类
	 */
	@Column(name = "sort", length = 255, unique = true, nullable = false)
	private String sort;

	/**
	 * 主键
	 */
	@Id
	@Column(name = "id", length = 36, unique = true, nullable = false)
	private String id;

	/**
	 * 备注
	 */
	@Column(name = "remark", length = 255, unique = true)
	private String remark;

	/**
	 * 字典值
	 */
	@Column(name = "dict_value", length = 255, unique = true, nullable = false)
	private String dictValue;

	/**
	 * 设置 排序值
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	/**
	 * 获取 排序值
	 */
	public Integer getSeq() {
		return this.seq;
	}

	/**
	 * 设置 状态：on，off
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取 状态：on，off
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 设置 操作用户
	 */
	public void setOpUserId(Integer opUserId) {
		this.opUserId = opUserId;
	}

	/**
	 * 获取 操作用户
	 */
	public Integer getOpUserId() {
		return this.opUserId;
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
	 * 设置 字典键
	 */
	public void setDictKey(String dictKey) {
		this.dictKey = dictKey;
	}

	/**
	 * 获取 字典键
	 */
	public String getDictKey() {
		return this.dictKey;
	}

	/**
	 * 设置 分类
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * 获取 分类
	 */
	public String getSort() {
		return this.sort;
	}

	/**
	 * 设置 主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 主键
	 */
	public String getId() {
		return this.id;
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
	 * 设置 字典值
	 */
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	/**
	 * 获取 字典值
	 */
	public String getDictValue() {
		return this.dictValue;
	}

	@Override
	public String toString() {
		return "SysDictionary [seq=" + seq + ", status=" + status + ", opUserId=" + opUserId + ", opTime=" + opTime
				+ ", dictKey=" + dictKey + ", sort=" + sort + ", id=" + id + ", remark=" + remark + ", dictValue="
				+ dictValue + "]";
	}

}
