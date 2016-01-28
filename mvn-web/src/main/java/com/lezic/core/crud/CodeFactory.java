/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 上午11:49:27</p>
 */
package com.lezic.core.crud;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lezic.app.crud.column.entity.CrudColumn;
import com.lezic.app.crud.table.entity.CrudTable;
import com.lezic.core.util.UtilClass;
import com.lezic.core.util.UtilData;
import com.lezic.core.util.UtilFile;
import com.lezic.core.util.UtilVelocity;

/**
 * 代码工厂
 * 
 * @author cielo
 *
 */
public class CodeFactory {

	public static Logger logger = LogManager.getLogger();

	public static String outputPath = "D:\\crud";

	public static void processTemplate(CrudTable table, List<CrudColumn> columns) throws IOException {
		String templatePath = UtilClass.getRootPath() + File.separator + "crud" + File.separator + "template"
				+ File.separator;

		String templateContent = null;// 模板内容
		String content = null;// 生成内容
		String destPath = null;// 生成路径

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", table);
		params.put("columns", columns);
		params.put("now", new Date());

		// entity
		logger.debug("自动生成 实体类......");
		String[] arr = UtilData.split(table.getEntity(), "/");
		String packageName = "com.lezic.app";
		for (int i = 0; i < arr.length - 1; i++) {
			packageName = packageName + "." + arr[i];
		}
		params.put("packageName", packageName);

		templateContent = UtilFile.getContent(templatePath + "Entity.java");
		content = UtilVelocity.process(templateContent, params);
		destPath = outputPath + File.separator + table.getEntityPackage().replace(".", File.separator) + File.separator
				+ table.getEntity() + ".java";
		UtilFile.write(destPath, content);
		logger.debug("生成成功！路径：" + destPath);

	}

	public static void main(String[] args) {

	}

}
