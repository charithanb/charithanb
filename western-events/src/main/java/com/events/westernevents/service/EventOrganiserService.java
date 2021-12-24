package com.events.westernevents.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.events.westernevents.repository.EventOrganiserRepository;
import com.tourcoreservice.entity.events.EventOrganiser;

@Service
public class EventOrganiserService {

	@Autowired
	private EventOrganiserRepository eOrganiserRepository;
	
	public EventOrganiser create(EventOrganiser eOrganiser) {
		return eOrganiserRepository.save(eOrganiser);
	}

	public EventOrganiser getById(long id) {
		return eOrganiserRepository.findById(id).get();
	}

	public List<EventOrganiser> listAll() {
		return eOrganiserRepository.findAll();
	}

	public void delete(long id) {
		eOrganiserRepository.deleteById(id);
	}

	public EventOrganiser Update(EventOrganiser eOrganiser) {
		return eOrganiserRepository.save(eOrganiser);
	}
}
