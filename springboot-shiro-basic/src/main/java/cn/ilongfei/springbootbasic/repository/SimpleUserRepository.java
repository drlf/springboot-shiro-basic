package cn.ilongfei.springbootbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.ilongfei.springbootbasic.domain.User;

//Spring Data提供了默认的事务处理方式，即所有的查询均声明为只读事务，对于持久化，更新与删除对象声明为有事务。可以在方法上注解@Transactional声明  
public interface SimpleUserRepository extends JpaRepository<User, Long> {
	
	/*List<M> findAll(Sort sort);  有时间测试一下sort或searchable的速度，还有是否有针对数据库的sql优化，如oracle的rownumber<10
	Page<M> findAll(Pageable pageable);
	public Page<M> findAll(Searchable searchable);
	public long count(Searchable searchable);*/
	
	List<User> findAll();
	
	/*@Modifying 
	@Query("update User u set u.name = ?1 where u.id = ?2") 
	int updateNameFor(String name, long id); 
	
	//命名参数
	@Query("select u from User u where u.name = :name or u.phone = :phone") 
	User findByLastnameOrPhone(@Param("name") String name,@Param("phone") String phone);*/
	
	User findByUsername(String username);
	
	/*User findById(long id);
	User findByName(String name);
	
	
	//List<User> findByLastname(String lastname);
	
	@Query("select u from User u where u.name = ?")
	List<User> queryByName(String name);*/
}
