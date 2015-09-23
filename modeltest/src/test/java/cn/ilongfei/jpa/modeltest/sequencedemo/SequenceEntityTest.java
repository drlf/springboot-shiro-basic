package cn.ilongfei.jpa.modeltest.sequencedemo;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Repeat;

import cn.ilongfei.jpa.modeltest.model.sequencedemo.UserWithSequenece;
/**
 * 测试oracle等使用sequence实现id的数据库
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SequenceEntityTest {

	private static final Logger log = LoggerFactory.getLogger(SequenceEntityTest.class);
	static EntityManagerFactory factory;
	EntityManager em;
	
	@BeforeClass    
    public static void beforeClass() {     
		factory = Persistence.createEntityManagerFactory("sequeneceTest");
    };     
      
    @AfterClass    
    public static void afterClass() {     
    	factory.close();
    };   
	
	@Before
    public void startUp() throws IOException {
		em=factory.createEntityManager();
		em.getTransaction().begin();
    }
	
	@After
    public void tearDown() {
		em.close();
    }
	
	@Test
	@Repeat(10)
    public void aSave() {
		log.info("Running {}", Thread.currentThread() .getStackTrace()[1].getMethodName());
		/*UserWithSequenece user = new UserWithSequenece();
		user.setName("小三");
        em.persist(user);*/
		for(int i =0;i<140 ;i++){
			UserWithSequenece user1 = new UserWithSequenece();
			user1.setName("小李");
			em.persist(user1);
		}
        
        em.getTransaction().commit();
    }
    
}
