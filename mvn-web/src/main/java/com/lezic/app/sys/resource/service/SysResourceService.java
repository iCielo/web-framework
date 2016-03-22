/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	Mon Mar 14 13:59:24 CST 2016</p>
 */
package com.lezic.app.sys.resource.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lezic.app.sys.resource.entity.SysResource;
import com.lezic.core.orm.service.BaseService;

/**
 * @author cielo
 *
 */
@Service
@Transactional
public class SysResourceService extends BaseService<SysResource> {
}
