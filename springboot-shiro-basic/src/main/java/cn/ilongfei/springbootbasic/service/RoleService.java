package cn.ilongfei.springbootbasic.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ilongfei.springbootbasic.domain.Role;
import cn.ilongfei.springbootbasic.domain.Role;
import cn.ilongfei.springbootbasic.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired RoleRepository roleRepository;
	public List<Role> findAll(){
		return roleRepository.findAll();
	}
	
	/**
     * 创建用户
     * @param role
     */
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

   @Transactional
	public Role update(Role role){
		if(role.getId() != 0){
			Role tmp = roleRepository.findOne(role.getId());
			tmp.setRole(role.getRole());
			tmp.setDescription(role.getDescription());
			//tmp.setSalt(role.getSalt());
			return tmp;
		}
		return null;
	}
	
	public Role find(long id){
		return roleRepository.findOne(id);
	}
	
	public void delete(long id){
		roleRepository.delete(id);
	}
		
}
