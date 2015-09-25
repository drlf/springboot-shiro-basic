package cn.ilongfei.springbootbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ilongfei.springbootbasic.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
