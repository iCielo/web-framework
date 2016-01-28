/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 上午10:10:18</p>
 */
package com.lezic.app.crud.column.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.lezic.app.crud.column.entity.CrudColumn;
import com.lezic.core.lang.ParamMap;
import com.lezic.core.orm.service.BaseService;
import com.lezic.core.util.UtilData;

/**
 * @author cielo
 *
 */
@Service
@Transactional
public class CrudColumnService extends BaseService<CrudColumn> {

	private Logger logger = LogManager.getLogger(getClass());

	/**
	 * 批量新增表字段数据
	 * 
	 * @param tableName
	 * @author cielo
	 */
	@SuppressWarnings("unchecked")
	public void batchNewColumn(String tableName) {
		Assert.isTrue(UtilData.isNotNull(tableName));
		ParamMap params = new ParamMap();
		params.put("tableName", tableName);
		params.put("tableSchema", "lezic");
		List<Object> columns = super.findM("framework.findTableColumns", params);
		List<CrudColumn> crudColumnList = new ArrayList<CrudColumn>();
		Date now = new Date();
		for (Object item : columns) {
			Map<String, Object> map = (Map<String, Object>) item;
			String columnName = map.get("columnName") + "";
			boolean isExist = super.isExist("select 1 from CrudColumn where tableName = ? and columnName = ?",
					tableName, columnName);
			if (isExist) {
				continue;
			}
			CrudColumn crudColumn = new CrudColumn();
			crudColumn.setColumnName(columnName);
			crudColumn.setNullable("YES".equals(map.get("isNullable") + "") ? 1 : 0);
			crudColumn.setPrimaryKey("PRI".equals(map.get("columnKey") + "") ? 1 : 0);
			crudColumn.setLabel(map.get("columnComment") + "");
			crudColumn.setColumnType(map.get("dataType") + "");
			crudColumn.setLength(UtilData.integerOfObject(map.get("length")));

			crudColumn.setTableName(tableName);
			crudColumn.setId(UUID.randomUUID().toString());
			crudColumn.setInputType("INPUT");
			crudColumn.setOpTime(now);
			crudColumn.setJavaName(UtilData.toCamel(columnName));
			crudColumn.setJavaMethodName(UtilData.firstUpperCase(crudColumn.getJavaName()));
			if ("int".equals(crudColumn.getColumnType())) {
				crudColumn.setJavaType("Integer");
			} else if ("datetime".equals(crudColumn.getColumnType())) {
				crudColumn.setJavaType("Date");
			} else {
				crudColumn.setJavaType("String");
			}

			StringBuffer rules = new StringBuffer();
			if (crudColumn.getNullable() == 0) {
				rules.append("required;");
			}
			if (crudColumn.getLength() != null) {
				rules.append("length(~" + crudColumn.getLength() + ");");
			}
			crudColumn.setRules(rules.toString());
			logger.debug(crudColumn.toString());
			crudColumnList.add(crudColumn);
		}
		super.batchSaveH(crudColumnList);
	}
}
