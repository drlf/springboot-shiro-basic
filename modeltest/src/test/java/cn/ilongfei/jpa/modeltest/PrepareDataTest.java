package cn.ilongfei.jpa.modeltest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cn.ilongfei.jpa.modeltest.model.User;
import cn.ilongfei.jpa.modeltest.repository.UserRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@TransactionConfiguration(defaultRollback = false)
public class PrepareDataTest {
	@Autowired protected UserRepository userRepository;
	@Before
    public void setUp() {
		User u1 = new User();
		u1.setUsername("lf");
		u1.setPassword("123");
		User tmp = userRepository.save(u1);
		System.out.println(tmp.getId());
	}
	
	@Test
    public void test() {
		
	}
}
