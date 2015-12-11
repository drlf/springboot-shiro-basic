package cn.ilongfei.springbootbasic.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

	private static Logger log = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		String say = "Hello.12"; 
		log.debug("/home output is: " + say);
		return say;
	}
}
