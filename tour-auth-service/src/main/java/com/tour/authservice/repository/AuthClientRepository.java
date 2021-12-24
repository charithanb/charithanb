package com.tour.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.OauthClientDetails;


@Repository
public interface AuthClientRepository extends JpaRepository<OauthClientDetails, Long> {

	OauthClientDetails findByClientId(String clientId);

}
