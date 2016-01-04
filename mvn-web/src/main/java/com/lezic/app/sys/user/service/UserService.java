package com.lezic.app.sys.user.service;

import org.springframework.stereotype.Service;

import com.lezic.app.sys.user.entity.User;

@Service
public class UserService {

	public User getEntity(String account) {
		User user = new User();
		user.setAccount(account);
		user.setName("cielo");
		user.setLoginName("22612312");
		user.setEmail("aksdjf@163.com");
		return user;
	}
}
