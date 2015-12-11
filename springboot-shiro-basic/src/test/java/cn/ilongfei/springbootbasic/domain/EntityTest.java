package cn.ilongfei.springbootbasic.domain;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityTest {

	private static final Logger log = LoggerFactory.getLogger(EntityTest.class);
	static EntityManagerFactory factory;
	EntityManager em;
	
	@BeforeClass    
    public static void beforeClass() {     
		factory = Persistence.createEntityManagerFactory("jpa");
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
	public void add() {
		log.info("Running {}", Thread.currentThread() .getStackTrace()[1].getMethodName());
		Permission perm= new Permission();
		perm.setPermission("user:create");
		User user = new User();
		user.setUsername("小三");
		UserBaseInfo baseInfo = new UserBaseInfo();
		baseInfo.setRealname("刘晓峰");
		user.setUserBaseInfo(baseInfo);
		Role role = new Role();
		role.setRole("aaa");
		role.addPermission(perm);
		user.addRole(role);
		
        em.persist(user);
        em.persist(role);
        em.persist(perm);
        em.persist(baseInfo);
        em.getTransaction().commit();
	}
	
	@Test 
	public void bGetUser(){
		log.info("Running {}", Thread.currentThread() .getStackTrace()[1].getMethodName());
		User user = em.find(User.class, 1L);
		System.out.println(user);
		/*for(Role role: user.getRoles()){
			System.out.println(role);
		}*/
	}

}
