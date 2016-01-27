/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 上午10:10:18</p>
 */
package com.lezic.app.crud.column.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lezic.app.crud.column.entity.CrudColumn;
import com.lezic.core.orm.service.BaseService;

/**
 * @author cielo
 *
 */
@Service
@Transactional
public class CrudColumnService extends BaseService<CrudColumn> {

}
