/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:57:39</p>
 */
package com.lezic.app.sys.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lezic.app.sys.user.entity.SysUser;
import com.lezic.core.orm.service.impl.BaseServiceImpl;

/**
 * @author cielo
 *
 */
@Service
@Transactional
public class SysUserService extends BaseServiceImpl<SysUser> {
}
