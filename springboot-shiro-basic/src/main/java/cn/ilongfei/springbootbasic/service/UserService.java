package cn.ilongfei.springbootbasic.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ilongfei.springbootbasic.domain.User;
import cn.ilongfei.springbootbasic.framework.shiro.PasswordHelper;
import cn.ilongfei.springbootbasic.repository.SimpleUserRepository;

@Service
public class UserService {
	@Autowired SimpleUserRepository simpleUserRepository;
	@Autowired private PasswordHelper passwordHelper;
	public List<User> findAll(){
		return simpleUserRepository.findAll();
	}
	
	/**
     * 创建用户
     * @param user
     */
    public User createUser(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        return simpleUserRepository.save(user);
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword) {
        User user = simpleUserRepository.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        simpleUserRepository.save(user);
    }

	@Transactional
	public User update(User user){
		if(user.getId() != 0){
			User tmp = simpleUserRepository.findOne(user.getId());
			tmp.setUsername(user.getUsername());
			tmp.setPassword(user.getPassword());
			tmp.setSalt(user.getSalt());
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
	
	public User findByUsername(String name){
		return simpleUserRepository.findByUsername(name);
	}
	
	public Set<String> findRoles(String name) {
		return new HashSet();
        //return userDao.findRoles(name);
    }
	
	public Set<String> findPermissions(String username) {
		return new HashSet();//return userDao.findPermissions(username);
    }
	
}
