/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:55:08</p>
 */
package com.lezic.app.crud.table.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lezic.app.crud.table.entity.CrudTable;
import com.lezic.core.orm.service.BaseService;

/**
 * @author cielo
 *
 */
@Service
@Transactional
public class CrudTableService extends BaseService<CrudTable> {
	
	/**
	 * 新增对象
	 * @param entity
	 * @author cielo
	 */
	public void addEntity(CrudTable entity){
		String tableName = entity.getTableName();
		if (entity != null) {
			entity.setId(UUID.randomUUID().toString());
		}
		super.saveH(entity);
	}

}
