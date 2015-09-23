package cn.ilongfei.jpa.modeltest.repository;

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
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import cn.ilongfei.jpa.modeltest.model.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);
	static RepositoryFactorySupport repoFactory; 
	static EntityManagerFactory factory;
	static EntityManager em;
	static UserRepository userRepo;
	
	@BeforeClass    
    public static void beforeClass() {     
		factory = Persistence.createEntityManagerFactory("jpa");
		em=factory.createEntityManager();
		repoFactory = new JpaRepositoryFactory (em);
		userRepo = repoFactory.getRepository(UserRepository.class);
    };     
      
    @AfterClass    
    public static void afterClass() {     
    	factory.close();
    };   
	
	@Before
    public void startUp() throws IOException {
		
		em.getTransaction().begin();
    }
	
	@After
    public void tearDown() {
		em.close();
    }
	
	@Test
	public void test() {
		User user = new User();
		user.setUsername("小米");
		userRepo.save(user);
		em.getTransaction().commit();
	}

}
