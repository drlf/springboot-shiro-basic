package cn.ilongfei.springbootbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.ilongfei.springbootbasic.domain.Role;
import cn.ilongfei.springbootbasic.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	RoleService roleService;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Role> list() {
		return roleService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Role findById(@PathVariable long id) {
		return roleService.find(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteById(@PathVariable long id) {
		roleService.delete(id);
		return "ok";
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public String update(@PathVariable long id, @RequestBody Role role) {
		if(role.getId() == id){
			roleService.update(role);
			return "OK.";
		}else{
			return "Failed.";
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Role save(@RequestBody Role role) {
		return roleService.createRole(role);
	}

}
