package cn.ilongfei.jpa.modeltest.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "user_role")
public class UserRole extends BaseEntity {

    private Long userId;
    private Long roleId;

    public UserRole(){
    	
    }
    
    public UserRole(Long userId, Long roleId){
    	this.userId = userId;
    	this.roleId = roleId;
    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
