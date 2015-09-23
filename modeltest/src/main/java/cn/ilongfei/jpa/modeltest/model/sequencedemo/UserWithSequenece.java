package cn.ilongfei.jpa.modeltest.model.sequencedemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Oracle自增序号实现BaseEntity
 * 
 */

/*
name 【必需】 SequenceGenerator 的名称必须匹配其 startegy 设置为 SEQUENCE 的 GeneratedValue 的名称。

allocationSize【可选】
默认值： 50.
默认情况下，JPA 持续性提供程序使用的分配大小为 50。
如果此分配大小与应用程序要求或数据库性能参数不匹配，请将 allocationSize 设置为所需的 int 值。

initialValue【可选】
默认值： 0.
默认情况下，JPA 持续性提供程序假设持续性提供程序将所有主键值的起始值设置为 0。
如果这与现有数据模型不匹配，请将 initialValue 设置为所需的 int 值。

sequenceName【可选】
默认值：JPA 持续性提供程序分配它自己创建的序列名。
如果要使用事先存在或预定义的序列，请将 sequenceName 设置为所需的 String 名称。*/
//allocationSize = 50 默认是50，先取出50个序列号，没有用完并不会返回，所以有时会出现序列号跳数字的现象。
@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_users")
@SequenceGenerator(name = "SEQ_STORE",  sequenceName = "tbl_user_sequence")
public class UserWithSequenece extends SequeneceBaseEntity {
	private String mid;

	private String name;

	@Column(name = "nick_name")
	private String nickName;

	private String password;

	private String mobile;

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
}
