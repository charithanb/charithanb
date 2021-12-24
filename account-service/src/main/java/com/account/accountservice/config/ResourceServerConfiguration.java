package com.account.accountservice.config;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.account.accountservice.service.AuditorAwareService;
import com.account.accountservice.service.CustomOAuth2UserService;
import com.google.common.collect.ImmutableList;

@Configuration
@EnableResourceServer
@PropertySource("classpath:constants.properties")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Autowired
	private ResourceServerProperties reource;

	@Autowired
	private CustomOAuth2UserService oauthUserService;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		/*
		 * http.cors().and().requestMatchers().antMatchers("/**").and().
		 * authorizeRequests().anyRequest().authenticated();
		 */

		http.authorizeRequests().antMatchers("/**", "/oauth/**").permitAll().and().formLogin().permitAll()
		.and().oauth2Login().loginPage("/login")
		.userInfoEndpoint().userService(oauthUserService);
	}

	@Primary
	@Bean
	public ResourceServerTokenServices tokenService() {
		CustomRemoteTokenService tokenServices = new CustomRemoteTokenService();
		tokenServices.setCheckTokenEndpointUrl(this.reource.getTokenInfoUri());
		tokenServices.setClientId(this.reource.getClientId());
		tokenServices.setClientSecret(this.reource.getClientSecret());
		return tokenServices;
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() {
		OAuth2AuthenticationManager authenticationManager = new OAuth2AuthenticationManager();
		authenticationManager.setTokenServices(tokenService());
		return authenticationManager;

	}

//	@Bean
//	public CorsConfigurationSource corsConfiguration() {
//		final CorsConfiguration configuration=new CorsConfiguration();
//		configuration.setAllowedOriginPatterns(ImmutableList.of("http://localhost:4200"));
//		configuration.setAllowedMethods(ImmutableList.of("GET","PUT","POST","DELETE","OPTIONS"));
//		configuration.setAllowCredentials(true);
//		configuration.setAllowedHeaders(ImmutableList.of("Authorization","Cache-Control","Content-Type"));
//		final UrlBasedCorsConfigurationSource source=  new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//          return source;
//	}
//	
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareService();
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}