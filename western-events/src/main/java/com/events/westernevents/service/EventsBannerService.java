package com.events.westernevents.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.events.westernevents.repository.EventsBannerRepository;
import com.tourcoreservice.entity.events.EventBanners;

@Service
public class EventsBannerService {

	@Autowired
	private EventsBannerRepository eBannerRepository;
	
	public EventBanners create(EventBanners eThemes) {
		return eBannerRepository.save(eThemes);
	}

	public EventBanners getById(long id) {
		return eBannerRepository.findById(id).get();
	}

	public List<EventBanners> listAll() {
		return eBannerRepository.findAll();
	}

	

	public void delete(long id) {
		eBannerRepository.deleteById(id);

	}

	public EventBanners Update(EventBanners eBanners) {
		return eBannerRepository.save(eBanners);
	}
}
