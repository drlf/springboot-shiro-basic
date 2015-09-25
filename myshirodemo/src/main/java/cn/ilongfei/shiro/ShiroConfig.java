package cn.ilongfei.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.ilongfei.shiro.util.PasswordHelper;
import cn.ilongfei.shiro.util.RetryLimitHashedCredentialsMatcher;
import cn.ilongfei.shiro.util.UserRealm;
import cn.ilongfei.shiro.util.UserService;

@Configuration
//@ImportResource("classpath:config/shiro-web.xml")
public class ShiroConfig {

	private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

	/*@Bean(name = "ShiroRealmImpl")
	public ShiroRealmImpl getShiroRealm() {
		return new UserRealm();
	}*/
	@Bean(name = "userRealm")
	public UserRealm getUserRealm(){
		PasswordHelper passwordHelper = new PasswordHelper();
		UserService userService = new UserService();
		userService.setPasswordHelper(passwordHelper);
		UserRealm userRealm = new UserRealm();
		userRealm.setUserService(userService);
		userRealm.setCredentialsMatcher(getCredentialsMatcher());
		//userRealm.setCachingEnabled(false);
		return userRealm;
	}
	@Bean(name = "credentialsMatcher")
	public CredentialsMatcher getCredentialsMatcher(){
		RetryLimitHashedCredentialsMatcher matcher = new RetryLimitHashedCredentialsMatcher(getCacheManager());
		matcher.setHashAlgorithmName("md5");
		matcher.setHashIterations(2);
		matcher.setStoredCredentialsHexEncoded(true);
		return matcher;
	}

	@Bean(name = "cacheManager")
	public EhCacheManager getCacheManager() {
		
		return getEhCacheManager();
	}
	
	@Bean(name = "shiroEhcacheManager")
	public EhCacheManager getEhCacheManager() {
		EhCacheManager em = new EhCacheManager();
		em.setCacheManagerConfigFile("classpath:config/shiro-ehcache.xml");
		return em;
	}

	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
		daap.setProxyTargetClass(true);
		return daap;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager() {
		DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
		dwsm.setRealm(getUserRealm());
		dwsm.setCacheManager(getEhCacheManager());
		return dwsm;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
		aasa.setSecurityManager(getDefaultWebSecurityManager());
		return new AuthorizationAttributeSourceAdvisor();
	}

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean
				.setSecurityManager(getDefaultWebSecurityManager());
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl("/success");
		//filterChainDefinitionMap.put("/sa/**", "authc");
		filterChainDefinitionMap.put("/", "anon");
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilterFactoryBean
				.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
}
