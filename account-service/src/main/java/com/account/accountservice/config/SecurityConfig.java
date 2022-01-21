package com.account.accountservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.httpBasic().and().authorizeRequests()
		.antMatchers("/user/**").hasRole("ADMIN")
		.antMatchers("/user/create").hasRole("USER")
		.anyRequest().authenticated()
		.and().csrf().disable().headers().frameOptions().disable();
	}
	
}
