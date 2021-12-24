package com.tour.authservice.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import com.tour.authservice.repository.AuthClientRepository;
import com.tourcoreservice.entity.OauthClientDetails;

@Service
public class AuthClientDetailsService implements ClientDetailsService {

	@Autowired
	AuthClientRepository authClientRepository;

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		OauthClientDetails oDetail = authClientRepository.findByClientId(clientId);
		BaseClientDetails details = new BaseClientDetails();
		details.setClientId(oDetail.getClientId());
		details.setAuthorizedGrantTypes(oDetail.getAuthorizedGrantTypes());
		details.setScope(oDetail.getScope());
		details.setResourceIds(oDetail.getResourceIds());
		details.setClientSecret(oDetail.getClientSecret());
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
		authorities.add(new SimpleGrantedAuthority("ROLE_TRUSTED_CLIENT"));
		details.setAuthorities(authorities);
		return details;
	}

}
