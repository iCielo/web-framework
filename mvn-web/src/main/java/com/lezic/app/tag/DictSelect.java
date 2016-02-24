/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午1:54:34</p>
 */
package com.lezic.app.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.lezic.app.cache.SystemCache;
import com.lezic.app.sys.dictionary.entity.SysDictionary;
import com.lezic.core.util.UtilData;

/**
 * 数据字典select标签
 * @author cielo
 *
 */
public class DictSelect extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	/** 数据字典类型 */
	private String sort;

	/** 标签id */
	private String id;

	/** 标签name */
	private String name;

	/** 选中的值 */
	private String key;

	/** 标签样式 */
	private String style;

	/** 标签class样式 */
	private String cssClass;

	/** 包含的值 */
	private String inValues;

	/** 不包含的值 */
	private String notInValues;
	
	@Override
	public int doStartTag() throws JspException {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("<select");
			if (UtilData.isNotNull(id)) {
				sb.append(" id=\"" + id + "\"");
			}
			if (UtilData.isNotNull(name)) {
				sb.append(" name=\"" + name + "\"");
			}
			if (UtilData.isNotNull(style)) {
				sb.append(" style=\"" + style + "\"");
			}
			if (UtilData.isNotNull(cssClass)) {
				sb.append(" class=\"" + cssClass + "\"");
			}
			sb.append(">");
			sb.append("<option value=\"\">------请选择-------</option>");
			List<SysDictionary> list = SystemCache.DICT_SORT_MAP.get(sort);
			
			if (list != null) {
				String[] inValuesArr = UtilData.split(inValues, ",");
				String[] notInValuesArr = UtilData.split(notInValues, ",");

				for (Iterator<SysDictionary> iterator = list.iterator(); iterator.hasNext();) {
					SysDictionary item = (SysDictionary) iterator.next();
					String dictKey = item.getDictKey();
					boolean addFlag = true;
					if (UtilData.isNotEmpty(inValuesArr) && UtilData.notContains(inValuesArr, dictKey)) {
						addFlag = false;
					}
					if (UtilData.isNotEmpty(notInValuesArr) && UtilData.contains(notInValuesArr, dictKey)) {
						addFlag = false;
					}
					if (addFlag == false) {
						continue;
					}
					if (dictKey.equals(key)) {
						sb.append("<option value=\"" + dictKey + "\" selected=\"selected\"	>"
								+ item.getDictValue() + "</option>");
					} else {
						sb.append("<option value=\"" + dictKey + "\">" + item.getDictValue() + "</option>");
					}

				}
			}
			sb.append("<select>");
			pageContext.getOut().write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public String getType() {
		return sort;
	}

	public void setType(String type) {
		this.sort = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getValue() {
		return key;
	}

	public void setValue(String value) {
		this.key = value;
	}

	public String getInValues() {
		return inValues;
	}

	public void setInValues(String inValues) {
		this.inValues = inValues;
	}

	public String getNotInValues() {
		return notInValues;
	}

	public void setNotInValues(String notInValues) {
		this.notInValues = notInValues;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
