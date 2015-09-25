package cn.ilongfei.springbootbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ilongfei.springbootbasic.domain.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
	
}
