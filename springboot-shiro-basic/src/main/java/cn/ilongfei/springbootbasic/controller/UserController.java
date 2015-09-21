package cn.ilongfei.springbootbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ilongfei.springbootbasic.domain.User;
import cn.ilongfei.springbootbasic.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<User> list() {
		return userService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable long id) {
		return userService.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteById(@PathVariable long id) {
		userService.delete(id);
		return "ok";
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public String update(@PathVariable long id, @RequestBody User user) {
		if(user.getId() == id){
			userService.update(user);
			return "OK.";
		}else{
			return "Failed.";
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public User save(@RequestBody User user) {
		return userService.save(user);
	}

}
