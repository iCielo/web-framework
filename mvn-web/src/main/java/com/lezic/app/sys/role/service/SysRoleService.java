/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	Thu Jan 28 18:26:36 CST 2016</p>
 */
package com.lezic.app.sys.role.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lezic.app.sys.role.entity.SysRole;
import com.lezic.core.orm.service.BaseService;

/**
 * @author cielo
 *
 */
@Service
@Transactional
public class SysRoleService extends BaseService<SysRole> {
}
