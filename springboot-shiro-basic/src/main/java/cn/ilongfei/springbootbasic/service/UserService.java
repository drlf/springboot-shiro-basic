package cn.ilongfei.springbootbasic.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ilongfei.springbootbasic.domain.User;
import cn.ilongfei.springbootbasic.repository.SimpleUserRepository;

@Service
public class UserService {
	@Autowired SimpleUserRepository simpleUserRepository;
	public List<User> findAll(){
		return simpleUserRepository.findAll();
	}
	
	public User save(User user){
		return simpleUserRepository.save(user);
	}
	
	@Transactional
	public User update(User user){
		if(user.getId() != 0){
			User tmp = simpleUserRepository.findOne(user.getId());
			tmp.setName(user.getName());
			tmp.setPassword(user.getPassword());
			tmp.setPhone(user.getPhone());
			return tmp;
		}
		return null;
	}
	
	public User findOne(long id){
		return simpleUserRepository.findOne(id);
	}
	
	public void delete(long id){
		simpleUserRepository.delete(id);
	}
	
	public User findByName(String name){
		return simpleUserRepository.findByName(name);
	}
	
	public Set<String> findRoles(String name) {
		return new HashSet();
        //return userDao.findRoles(name);
    }
	
	public Set<String> findPermissions(String username) {
		return new HashSet();//return userDao.findPermissions(username);
    }
	
}
