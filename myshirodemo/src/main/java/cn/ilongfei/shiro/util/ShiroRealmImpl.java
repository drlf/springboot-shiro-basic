/*********************************************************************
 * 源代码版权归作者（们）所有
 *
 * 以 Apache License, Version 2.0 方式授权使用，具体参见：
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 ********************************************************************/
package cn.ilongfei.shiro.util;

import java.io.Serializable;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * http://shiro.apache.org/java-authentication-guide.html
 * 
 * Subject Security specific user 'view' of an application user. It can be a
 * human being, a third-party process, a server connecting to you application
 * application, or even a cron job. Basically, it is anything or anyone
 * communicating with your application.
 * 
 * Principals A subjects identifying attributes. First name, last name, social
 * security number, username
 * 
 * Credentials secret data that are used to verify identities. Passwords,
 * Biometric data, x509 certificates,
 * 
 * Realms Security specific DAO, data access object, software component that
 * talkts to a backend data source. If you have usernames and password in LDAP,
 * then you would have an LDAP Realm that would communicate with LDAP. The idea
 * is that you would use a realm per back-end data source and Shiro would know
 * how to coordinate with these realms together to do what you have to do.
 * 
 * @author 李鹏
 * 
 */

//作废
public class ShiroRealmImpl extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out
				.println(" 由于加入了缓存, 此处只会load一次：doGetAuthorizationInfo.................");

		// 得到 doGetAuthenticationInfo 方法中传入的凭证
		ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName())
				.iterator().next();

		String userName = shiroUser.getName();
		if ("龙飞".equals(userName)) {

			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

			// 这个确定页面中<shiro:hasRole>标签的name的值
			info.addRole("admin");
			// 这个就是页面中 <shiro:hasPermission> 标签的name的值
			info.addStringPermission("user:edit");

			return info;
		} else if ("test".equals(userName)) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

			// 这个确定页面中<shiro:hasRole>标签的name的值
			info.addRole("test");
			// 这个就是页面中 <shiro:hasPermission> 标签的name的值, 这个串 随便的,不过我还是认为 白衣的好。
			info.addStringPermission("user:view");

			return info;
		} else {
			return null;
		}
	}

	/**
	 * AuthenticationInfo represents a Subject's (aka user's) stored account
	 * information relevant to the authentication/log-in process only.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		/**
		 * Constructor that takes in a single 'primary' principal of the
		 * account, its corresponding hashed credentials, the salt used to hash
		 * the credentials, and the name of the realm to associate with the
		 * principals. This is a convenience constructor and will construct a
		 * PrincipalCollection based on the principal and realmName argument.
		 * 
		 * 
		 * Parameters:
		 * 
		 * principal - the 'primary' principal associated with the specified
		 * realm. hashedCredentials - the hashed credentials that verify the
		 * given principal. credentialsSalt - the salt used when hashing the
		 * given hashedCredentials realmName - the realm from where the
		 * principal and credentials were acquired.
		 */
		UsernamePasswordToken usernamePasswordToke = (UsernamePasswordToken) token;

		String username = usernamePasswordToke.getUsername();

		String encodedPassword = new Sha256Hash(
				usernamePasswordToke.getPassword()).toBase64();

		System.out
				.println("====================认证  begin ==========================");
		System.out.println("username: " + username);
		System.out.println("password: " + encodedPassword);
		System.out.println("principal: " + usernamePasswordToke.getPrincipal());
		System.out
				.println("======================认证  end ========================");

		return new SimpleAuthenticationInfo(new ShiroUser("admin", "00011",
				"龙飞"), String.valueOf(usernamePasswordToke.getPassword()),
				ByteSource.Util.bytes("admin"), getName());
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840081L;
		public String id;
		public String number;
		public String name;

		public ShiroUser(String userid, String number, String name) {
			this.id = userid;
			this.number = number;
			this.name = name;
		}

		public ShiroUser(String number, String name) {
			this.number = number;
			this.name = name;
		}

		public String getName() {
			return name;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return number;
		}

		public String getDisplayName() {
			return name;
		}

	}

}
