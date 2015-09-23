package cn.ilongfei.jpa.modeltest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cn.ilongfei.jpa.modeltest.model.User;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	List<User> findByUsername(@Param("name") String name);
// extends JpaRepository<User, Long> {
	
	/*List<User> findAll();
	
	@Modifying 
	@Query("update User u set u.name = ?1 where u.id = ?2") 
	int updateNameFor(String name, long id); 
	
	//命名参数
	@Query("select u from User u where u.name = :name or u.phone = :phone") 
	User findByLastnameOrPhone(@Param("name") String name,@Param("phone") String phone);
	
	User findByName(String name);*/
	
	/*User findById(long id);
	User findByName(String name);
	
	
	//List<User> findByLastname(String lastname);
	
	@Query("select u from User u where u.name = ?")
	List<User> queryByName(String name);*/
}
