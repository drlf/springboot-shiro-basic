package cn.ilongfei.springbootbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ilongfei.springbootbasic.domain.UserBaseInfo;

public interface UserBaseInfoRepository extends JpaRepository<UserBaseInfo, Long> {
	
}
