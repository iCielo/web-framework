/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:55:08</p>
 */
package com.lezic.app.crud.table.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lezic.app.crud.table.entity.CrudTable;
import com.lezic.core.orm.service.impl.BaseServiceImpl;

/**
 * @author cielo
 *
 */
@Service
@Transactional
public class CrudTableService extends BaseServiceImpl<CrudTable> {

}
