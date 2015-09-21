package cn.ilongfei.springbootbasic.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="tbl_user")
//@JsonIgnoreProperties(value = {"handler"})
//@NamedQuery(name = "User.findByTheUsersName", query = "from User u where u.username = ?1")
/**定义多个nameQuery
 @NamedQueries(value = { 
        @NamedQuery(name = User.QUERY_FIND_BY_LOGIN, query = "select u from User u where u." + User.PROP_LOGIN  + " = :username"), 
        @NamedQuery(name = "getUsernamePasswordToken", query = "select new com.aceona.weibo.vo.TokenBO(u.username,u.password) from User u where u." + User.PROP_LOGIN+ " = :username")}
		)*/ 

public class User  {//extends AbstractPersistable<Long>
	
	//private static final long serialVersionUID = 1L;
	
	
	
	//@Column(unique = true)
	private String name;
	private String password;
	private String phone;
	private String salt;
	private Boolean locked = Boolean.FALSE;
	//@Version
    //@JsonIgnore
    //private Long version;
	/*
	@OneToMany
    private List<Role> roles;
    
    来自spring-data-jap-examples-master/spring-data-jap-showcase/core/Account.java
    @Temporal(TemporalType.DATE)
	private Date expiryDate; 
    
    
	*/
	private long id;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	/*public List<Role> getRoles() {
        if (roles == null) {
            this.roles = new ArrayList<>();
        }
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }*/
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	
	@Transient
	public String getCredentialsSalt() {
        return name + salt;
    }
	
	//统一的toString()方法
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
