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

@RequestMapping("/access")
@RestController
public class AccessController {

	private static Logger log = LoggerFactory.getLogger(AccessController.class);

	@Autowired
	UserService userService;
	@Autowired AccessService accessService;

	// 验证用户名和密码，输出refereshToken
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map showLoginForm(@RequestBody User user) {
		// userService.
		Map result = accessService.login(user.getUsername(), user.getPassword());
		return result;
	}

	// 使用refershToken更新accessToken
	@RequestMapping(value = "/referesh", method = RequestMethod.POST)
	@ResponseBody
	public Map referesh(@RequestBody String refereshToken) {
		// TODO 从cache中获取refereshToken，如果未实效
		
		Map result = accessService.referesh(refereshToken);
		return result;
	}

}
