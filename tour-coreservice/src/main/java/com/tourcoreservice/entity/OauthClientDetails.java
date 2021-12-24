package com.tourcoreservice.entity;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

@Entity
@Table(name = "oauth_client_details")
public class OauthClientDetails implements ClientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	@Column(name = "client_id")
	private String clientId;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "resource_ids")
	private String resourceIds;

	@Column(name = "client_secret")
	private String clientSecret;

	@Column(name = "scope")
	private String scope;

	@Column(name = "authorized_grant_types")
	private String authorizedGrantTypes;

	@Column(name = "web_server_redirect_uri")
	private String webServerRedirectUri;

	@Column(name = "authorities")
	private String authorities;

	@Column(name = "access_token_validity", length = 11)
	private Integer accessTokenValidity;

	@Column(name = "refresh_token_validity", length = 11)
	private Integer refreshTokenValidity;

	@Column(name = "additional_information", length = 4096)
	private String additionalInformation;

	@Column(name = "autoapprove", columnDefinition = "TINYINT(4)")
	private Integer autoapprove;

	@Column(name = "uuid")
	private String uuid;

	@Column
	private Date created;

	@Column(columnDefinition = "boolean default true")
	private Boolean enabled;

	@Transient
	private String[] scopes;

	@Transient
	private String[] grantTypes;

	@Transient
	private String ownerEmail;
	
	

	@Override
	public String getClientId() {
		// TODO Auto-generated method stub
		return clientId;
	}

	@Override
	public Set<String> getResourceIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSecretRequired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getClientSecret() {
		// TODO Auto-generated method stub
		return clientSecret;
	}

	@Override
	public boolean isScoped() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<String> getScope() {
		// TODO Auto-generated method stub
		return StringUtils.commaDelimitedListToSet(scope);
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		// TODO Auto-generated method stub
		return StringUtils.commaDelimitedListToSet(authorizedGrantTypes);
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return accessTokenValidity;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return refreshTokenValidity;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
