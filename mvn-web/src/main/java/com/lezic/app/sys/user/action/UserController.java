package com.lezic.app.sys.user.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "index";
	}
}
