package com.lezic.app.crud.column.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lezic.core.crud.annotation.WebField;

/**
 * SysUser generated by codeTool
 * 
 * @author cielo
 * @date 2016-01-27 10:06:35
 */
@Entity
@Table(name = "crud_column")
public class CrudColumn implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID", length = 36, unique = true, nullable = false)
	@WebField(label = "主键ID", placeholder = "请输入主键ID", rules = "required;length(~36);", length = 36, unique = true, nullable = false)
	private String id;

	@Column(name = "TABLE_NAME", length = 50, nullable = false)
	@WebField(label = "表名", placeholder = "请输入表名", rules = "required;length(~50);", length = 50, nullable = false)
	private String tableName;

	@Column(name = "COLUMN_NAME", length = 50, nullable = false)
	@WebField(label = "列名", placeholder = "请输入列名", rules = "required;length(~50);", length = 50, nullable = false)
	private String columnName;

	@Column(name = "COLUMN_TYPE", length = 50, nullable = false)
	@WebField(label = "数据类型", placeholder = "请输入数据类型", rules = "required;length(~50);", length = 50, nullable = false)
	private String columnType;

	@Column(name = "JAVA_NAME", length = 50, nullable = false)
	private String javaName;

	@Column(name = "JAVA_METHOD_NAME", length = 50, nullable = false)
	private String javaMethodName;

	@Column(name = "JAVA_TYPE", length = 50, nullable = false)
	@WebField(label = "数据类型", placeholder = "请输入数据类型", rules = "required;length(~50);", length = 50, nullable = false)
	private String javaType;

	@Column(name = "LABEL", length = 50, nullable = false)
	@WebField(label = "显示名", placeholder = "请输入显示名", rules = "required;length(~50);", length = 50, nullable = false)
	private String label;

	@Column(name = "PLACEHOLDER", length = 100)
	@WebField(label = "输入提示", placeholder = "请输入输入提示", rules = "length(~100);", length = 100)
	private String placeholder;

	@Column(name = "INPUT_TYPE", length = 50, nullable = false)
	@WebField(label = "数据录入类型 INPUT：输入框，RADIO：单选，SELECT：下拉框，CHECK：复选框", placeholder = "请输入数据录入类型 INPUT：输入框，RADIO：单选，SELECT：下拉框，CHECK：复选框", rules = "required;length(~50);", length = 50, nullable = false)
	private String inputType;

	@Column(name = "DICT_TYPE", length = 50)
	@WebField(label = "数据字典类型", placeholder = "请输入数据字典类型", rules = "length(~50);", length = 50)
	private String dictType;

	@Column(name = "DICT_LIST", length = 255)
	@WebField(label = "自定义数据字典", placeholder = "请输入自定义数据字典", rules = "length(~255);", length = 255)
	private String dictList;

	@Column(name = "NULLABLE", length = 0)
	@WebField(label = "是否可空", placeholder = "请输入是否可空", rules = "", length = 0)
	private Integer nullable;

	@Column(name = "LENGTH", length = 0)
	@WebField(label = "字符长度", placeholder = "请输入字符长度", rules = "", length = 0)
	private Integer length;

	@Column(name = "RULES", length = 255, nullable = false)
	@WebField(label = "校验规则", placeholder = "请输入校验规则", rules = "required;length(~255);", length = 255, nullable = false)
	private String rules;

	@Column(name = "OP_USER_ID", length = 36)
	@WebField(label = "操作用户", placeholder = "请输入操作用户", rules = "length(~36);", length = 36)
	private String opUserId;

	@Column(name = "OP_TIME", length = 0)
	@WebField(label = "操作时间", placeholder = "请输入操作时间", rules = "", length = 0)
	private Date opTime;

	/**
	 * 设置 主键ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 主键ID
	 */
	public String getId() {
		return this.id;
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
	 * 设置 列名
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * 获取 列名
	 */
	public String getColumnName() {
		return this.columnName;
	}

	/**
	 * 设置 数据类型
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	/**
	 * 获取 数据类型
	 */
	public String getColumnType() {
		return this.columnType;
	}

	/**
	 * 设置 显示名
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 获取 显示名
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * 设置 输入提示
	 */
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	/**
	 * 获取 输入提示
	 */
	public String getPlaceholder() {
		return this.placeholder;
	}

	/**
	 * 设置 数据录入类型 INPUT：输入框，RADIO：单选，SELECT：下拉框，CHECK：复选框
	 */
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	/**
	 * 获取 数据录入类型 INPUT：输入框，RADIO：单选，SELECT：下拉框，CHECK：复选框
	 */
	public String getInputType() {
		return this.inputType;
	}

	/**
	 * 设置 数据字典类型
	 */
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	/**
	 * 获取 数据字典类型
	 */
	public String getDictType() {
		return this.dictType;
	}

	/**
	 * 设置 自定义数据字典
	 */
	public void setDictList(String dictList) {
		this.dictList = dictList;
	}

	/**
	 * 获取 自定义数据字典
	 */
	public String getDictList() {
		return this.dictList;
	}

	/**
	 * 设置 是否可空
	 */
	public void setNullable(Integer nullable) {
		this.nullable = nullable;
	}

	/**
	 * 获取 是否可空
	 */
	public Integer getNullable() {
		return this.nullable;
	}

	/**
	 * 设置 字符长度
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

	/**
	 * 获取 字符长度
	 */
	public Integer getLength() {
		return this.length;
	}

	/**
	 * 设置 校验规则
	 */
	public void setRules(String rules) {
		this.rules = rules;
	}

	/**
	 * 获取 校验规则
	 */
	public String getRules() {
		return this.rules;
	}

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

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	@Override
	public String toString() {
		return "CrudColumn [id=" + id + ", tableName=" + tableName + ", columnName=" + columnName + ", columnType="
				+ columnType + ", label=" + label + ", placeholder=" + placeholder + ", inputType=" + inputType
				+ ", dictType=" + dictType + ", dictList=" + dictList + ", nullable=" + nullable + ", length=" + length
				+ ", rules=" + rules + ", opUserId=" + opUserId + ", opTime=" + opTime + "]";
	}

	public String getJavaName() {
		return javaName;
	}

	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}

	public String getJavaMethodName() {
		return javaMethodName;
	}

	public void setJavaMethodName(String javaMethodName) {
		this.javaMethodName = javaMethodName;
	}

}
