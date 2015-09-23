package cn.ilongfei.jpa.modeltest.school;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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

import cn.ilongfei.jpa.modeltest.model.school.Student;
import cn.ilongfei.jpa.modeltest.model.school.Teacher;
/**
 * 注意：persistence中指定了hibernate.hbm2ddl.auto=create,所以每次测试时都会先删除所有表，再建表
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManyToManyTest {

	private static final Logger log = LoggerFactory.getLogger(ManyToManyTest.class);
	static EntityManagerFactory factory;
	EntityManager em;
	
	@BeforeClass    
    public static void beforeClass() {     
		factory = Persistence.createEntityManagerFactory("modeltest");
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
    public void aSave() {
		log.info("Running {}", Thread.currentThread() .getStackTrace()[1].getMethodName());
        em.persist(new Teacher("张老师"));
        em.persist(new Student("小张"));
        em.persist(new Student("小黄"));
        em.getTransaction().commit();
    }
    
    /**
     * 为老师添加一个学生
     *
     */
    @Test
    public void build() {
    	log.info("Running {}", Thread.currentThread() .getStackTrace()[1].getMethodName());
        Teacher teacher = em.find(Teacher.class, 1);
        teacher.addStudent(em.getReference(Student.class, 1));
        teacher.addStudent(em.getReference(Student.class, 2));
        em.getTransaction().commit();
    }

    /**
     * 查询老师是否有2个学生
     */
    @Test
    public void cGetTeacherStudents() {
    	log.info("Running {}", Thread.currentThread() .getStackTrace()[1].getMethodName());
        Teacher teacher = em.find(Teacher.class, 1);
        assertThat(teacher.getStudents().size(), is(2));
        for(Student student: teacher.getStudents()){
        	assertThat(student.getName(), anyOf(equalTo("小张"),equalTo("小黄")));
        }
    }
    
    /**
     * 解除学生跟老师的关系
     *
     */
    @Test
    public void  dRemove() {
    	log.info("Running {}", Thread.currentThread() .getStackTrace()[1].getMethodName());
        Teacher teacher = em.find(Teacher.class, 1);
        teacher.removeStudent(em.getReference(Student.class, 2));
        em.getTransaction().commit();
        assertThat(teacher.getStudents().size(), equalTo(1));
    }
    
    /**
     * 删除学生，因为学生不是关系维护者，所以需要先手工解除老师与学生的关联，然后再删除学生
     * 如果不解除关系就删除学生，会报主键约束错误。
     */
    @Test
    public void  eDeleteStudent() {
    	log.info("Running {}", Thread.currentThread() .getStackTrace()[1].getMethodName());
        Teacher teacher = em.find(Teacher.class, 1);
        Student student = em.getReference(Student.class, 1);
        teacher.removeStudent(student); //手工解除老师与学生的关系
        em.remove(student); //删除学生
        
        em.getTransaction().commit();
    }
    
    /**
     * 删除老师，因为老师是关系维护者，所以可以直接解除老师与学生的关系，不用我们手工解除
     *
     */
    @Test
    public void fDeleteTeacher() {
    	log.info("Running {}", Thread.currentThread() .getStackTrace()[1].getMethodName());
    	Teacher teacher = em.find(Teacher.class, 1);
        teacher.addStudent(em.getReference(Student.class, 2));
        em.remove(teacher);
        em.getTransaction().commit();
        //em.remove(em.getReference(Teacher.class, 3));
    }
    
    
}
