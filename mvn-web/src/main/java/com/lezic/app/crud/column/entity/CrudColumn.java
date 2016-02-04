package com.lezic.app.crud.column.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 表字段
 * 
 * @author cielo
 * @date Wed Feb 03 16:53:56 CST 2016
 */
@Entity
@Table(name = "crud_column")
public class CrudColumn implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * java用以方法的命名，即字段首字母大写
	 */
	@Column(name = "JAVA_METHOD_NAME", length = 255)
	private String javaMethodName;

	/**
	 * 校验规则
	 */
	@Column(name = "RULES", length = 255, nullable = false)
	private String rules;

	/**
	 * 数据字典类型
	 */
	@Column(name = "DICT_TYPE", length = 50)
	private String dictType;

	/**
	 * 输入提示
	 */
	@Column(name = "PLACEHOLDER", length = 100)
	private String placeholder;

	/**
	 * 字符长度
	 */
	@Column(name = "LENGTH")
	private Integer length;

	/**
	 * 表名
	 */
	@Column(name = "TABLE_NAME", length = 50, nullable = false)
	private String tableName;

	/**
	 * 显示名
	 */
	@Column(name = "LABEL", length = 50, nullable = false)
	private String label;

	/**
	 * 数据类型
	 */
	@Column(name = "COLUMN_TYPE", length = 50, nullable = false)
	private String columnType;

	/**
	 * 自定义数据字典
	 */
	@Column(name = "DICT_LIST", length = 255)
	private String dictList;

	/**
	 * 主键ID
	 */
	@Id
	@Column(name = "ID", length = 36, unique = true, nullable = false)
	private String id;

	/**
	 * 操作用户
	 */
	@Column(name = "OP_USER_ID", length = 36)
	private String opUserId;

	/**
	 * 是否主键
	 */
	@Column(name = "PRIMARY_KEY")
	private Integer primaryKey;

	/**
	 * 操作时间
	 */
	@Column(name = "OP_TIME")
	private Date opTime;

	/**
	 * 数据录入类型 INPUT：输入框，RADIO：单选，SELECT：下拉框，CHECK：复选框
	 */
	@Column(name = "INPUT_TYPE", length = 50, nullable = false)
	private String inputType;

	/**
	 * 是否可空
	 */
	@Column(name = "NULLABLE")
	private Integer nullable;

	/**
	 * 列名
	 */
	@Column(name = "COLUMN_NAME", length = 50, nullable = false)
	private String columnName;

	/**
	 * java名称
	 */
	@Column(name = "JAVA_NAME", length = 50, nullable = false)
	private String javaName;

	/**
	 * java类型
	 */
	@Column(name = "JAVA_TYPE", length = 50, nullable = false)
	private String javaType;

	/**
	 * 设置 java用以方法的命名，即字段首字母大写
	 */
	public void setJavaMethodName(String javaMethodName) {
		this.javaMethodName = javaMethodName;
	}

	/**
	 * 获取 java用以方法的命名，即字段首字母大写
	 */
	public String getJavaMethodName() {
		return this.javaMethodName;
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
	 * 设置 是否主键
	 */
	public void setPrimaryKey(Integer primaryKey) {
		this.primaryKey = primaryKey;
	}

	/**
	 * 获取 是否主键
	 */
	public Integer getPrimaryKey() {
		return this.primaryKey;
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
	 * 设置 java名称
	 */
	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}

	/**
	 * 获取 java名称
	 */
	public String getJavaName() {
		return this.javaName;
	}

	/**
	 * 设置 java类型
	 */
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	/**
	 * 获取 java类型
	 */
	public String getJavaType() {
		return this.javaType;
	}

}
