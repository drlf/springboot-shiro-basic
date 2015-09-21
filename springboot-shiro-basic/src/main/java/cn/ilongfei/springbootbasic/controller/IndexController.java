package cn.ilongfei.springbootbasic.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
@RequestMapping("/")
public class IndexController {

	private static Logger log = Logger.getLogger(IndexController.class);
	//private static Logger log = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String home() {
		return "login";
	}
}
