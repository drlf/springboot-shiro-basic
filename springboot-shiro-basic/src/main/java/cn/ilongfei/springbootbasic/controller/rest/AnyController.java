package cn.ilongfei.springbootbasic.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.ilongfei.springbootbasic.domain.User;
import cn.ilongfei.springbootbasic.service.AccessService;
import cn.ilongfei.springbootbasic.service.UserService;

@RequestMapping("/api")
@RestController
public class AnyController {

	private static Logger log = LoggerFactory.getLogger(AnyController.class);

	// 验证用户名和密码，输出refereshToken
	@RequestMapping(value = "/settings")
	public Map showLoginForm(@RequestBody User user) {
		// userService.
		Map result = new HashMap();
		result.put("","");
		return result;
	}
	/*
	@RequestMapping(value = "/files")
	public Map showLoginForm(@RequestBody User user) {
		// userService.
		Map result = new HashMap();
		result.put("","");
		return result;
	}*/

	

}
