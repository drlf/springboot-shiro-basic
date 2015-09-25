package cn.ilongfei.shiro.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service

public class UserService {

	public static User user = new User("admin","3929bb9a874a4d3cac46db881d81dec1");
	
	@Autowired
    private PasswordHelper passwordHelper;
	
	public void setPasswordHelper(PasswordHelper passwordHelper){
		this.passwordHelper = passwordHelper;
	}
    /**
     * 创建用户
     * @param user
     */
    /*public User createUser(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        return userDao.createUser(user);
    }

    
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    
    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }

    *//**
     * 修改密码
     * @param userId
     * @param newPassword
     *//*
    public void changePassword(Long userId, String newPassword) {
        User user =userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    
    public User findOne(Long userId) {
        return userDao.findOne(userId);
    }

    
    public List<User> findAll() {
        return userDao.findAll();
    }*/

	
	private User getMockUser(){
		user.setSalt("salt123456");
		return user;
	}
	
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return getMockUser();
    }

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        /*User user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findRoles(user.getRoleIds().toArray(new Long[0]));*/
    	Set<String> roles = new HashSet<String>();
    	roles.add("admin");
    	return roles;
    }

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        /*User user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findPermissions(user.getRoleIds().toArray(new Long[0]));*/
    	Set<String> permissions = new HashSet<String>();
    	permissions.add("user:create");
    	return permissions;
    }

}
