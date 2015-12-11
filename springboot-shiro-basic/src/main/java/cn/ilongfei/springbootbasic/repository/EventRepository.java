package cn.ilongfei.springbootbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ilongfei.springbootbasic.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	
}
