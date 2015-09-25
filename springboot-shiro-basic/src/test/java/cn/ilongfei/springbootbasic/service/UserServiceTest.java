package cn.ilongfei.springbootbasic.service;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ilongfei.springbootbasic.RepositoryTestConfig;
import cn.ilongfei.springbootbasic.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = RepositoryTestConfig.class)
public class UserServiceTest {

	@Autowired UserService userService;
	User user;

	@Before
	public void setUp() {
		user = new User();
		user.setUsername("lf");
		user.setPassword("123456");
		user.setSalt("12311111111");
	}
	
	@Test
	public void save() {
		user = userService.createUser(user);
		assertThat(user.getId(), not(0L));
	}
	
	@Test
	public void list() {
		List<User> users = userService.findAll();
		assertThat(users.size(), not(0));
		for(User user: users){
			System.out.println("user:" + user.getUsername());
		}
	}

}
