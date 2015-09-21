package cn.ilongfei.springbootbasic.repository;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ilongfei.springbootbasic.RepositoryTestConfig;
import cn.ilongfei.springbootbasic.domain.User;

import static org.junit.Assert.*;  
import static org.hamcrest.CoreMatchers.*;  
import static org.junit.matchers.JUnitMatchers.*;

import java.util.List; 

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = RepositoryTestConfig.class)
public class SimpleUserRepositoryTest {
	@Autowired SimpleUserRepository simpleUserRepository;
	User user;

	@Before
	public void setUp() {
		user = new User();
		user.setName("lf");
		user.setPassword("123456");
		user.setPhone("12311111111");
	}
	
	//@Test
	public void save() {
		user = simpleUserRepository.save(user);
		assertThat(user.getId(), not(0L));
	}
	
	@Test
	public void update() {
		user = simpleUserRepository.save(user);
		user.setName("drlf");
		User tmp = simpleUserRepository.findOne(user.getId());
		assertThat(tmp.getName(), is("drlf"));
	}
	
	/**
	 * 直接new一个User，想通过指定其id达到更新已有User记录是不行的，必须先获取过该User，然后才能通过指定Id
	 * 达到更新的目的。可能是缓存的原因，但是更新的时间间隔是多少呢？有无可能时间超过系统间隔时间，更新操作变成了new操作？
	 */
	//@Test
	public void updateNewUser() {
		user = simpleUserRepository.save(user);
		long id = user.getId();
		//long id = 86;
		User tmp = new User();
		tmp.setId(id);
		tmp.setName("fflf");
		tmp.setPassword("00123456");
		tmp.setPhone("12311111111");
		User tmp1 = simpleUserRepository.save(tmp);
		assertThat(tmp1.getId(), is(86L));
		User tmp3 = simpleUserRepository.findOne(id);
		assertThat(tmp3.getName(), is("fflf"));
	}
	
	//同一个事务中，必须flush才能看到更新后的数据
	//update必须使用@Transactional申明
	//TODO 问题：如果先save，再update，然后取user数据，此时数据是未更新的？为什么，是缓存的原因吗？
	//@Test
	public void testUpdateNameFor() {
		/*user = simpleUserRepository.saveAndFlush(user);
		long id = user.getId();*/
		long id= 1;
		simpleUserRepository.updateNameFor("dddlf", id);
		simpleUserRepository.flush();
		User tmp = simpleUserRepository.findOne(id);
		assertThat(tmp.getName(), is("dddlf"));
	}
	
	
	//@Test
	public void list() {
		List<User> users = simpleUserRepository.findAll();
		assertThat(users.size(), not(0));
		/*int i=0;
		for(User user: simpleUserRepository.findAll()){
			System.out.println("count: " + i++ + " user:" + user.getName());
		}*/
	}
}
