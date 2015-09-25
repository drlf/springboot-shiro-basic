package cn.ilongfei.springbootbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ilongfei.springbootbasic.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
}
