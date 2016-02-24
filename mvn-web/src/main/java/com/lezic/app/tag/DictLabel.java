/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午2:54:58</p>
 */
package com.lezic.app.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.lezic.app.cache.SystemCache;
import com.lezic.app.sys.dictionary.entity.SysDictionary;
import com.lezic.core.util.UtilData;

/**
 * 数据字典label标签
 * @author cielo
 *
 */
public class DictLabel extends TagSupport {

	/** 数据字典类型 */
	private String sort;

	/** 数据字典Id */
	private String dictId;

	/** 数据字典值 */
	private String key;

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		try {
			SysDictionary item = null;
			if (UtilData.isNotNull(key)) {
				item = SystemCache.getSysDictionary(sort, key);
			} else {
				item = SystemCache.DICT_ID_MAP.get(dictId);
			}
			if (item != null) {
				pageContext.getOut().write(item.getDictValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}
