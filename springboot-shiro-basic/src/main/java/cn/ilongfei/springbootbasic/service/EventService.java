package cn.ilongfei.springbootbasic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ilongfei.springbootbasic.domain.Event;
import cn.ilongfei.springbootbasic.repository.EventRepository;

@Service
public class EventService {
	private static Logger log = LoggerFactory.getLogger(EventService.class);

	@Autowired EventRepository eventRepository;

	public List<Event> findAll(){
		return eventRepository.findAll();
	}
	
	/**
     * 创建用户
     * @param Event
     */
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }


	@Transactional
	public Event update(Event event){
		if(event.getId() != 0){
			Event tmp = eventRepository.findOne(event.getId());
			tmp.setName(event.getName());
			tmp.setDescription(event.getDescription());
			tmp.setImage(event.getImage());
			tmp.setEndDate(event.getEndDate());
			tmp.setStartDate(event.getStartDate());
			return tmp;
		}
		return null;
	}
	
	public Event findOne(long id){
		return eventRepository.findOne(id);
	}
	
	public void delete(long id){
		eventRepository.delete(id);
	}
	

	
}
