package com.events.westernevents.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tourcoreservice.entity.events.EventOrganiser;

@Repository
public interface EventOrganiserRepository extends JpaRepository<EventOrganiser, Long>{

}
