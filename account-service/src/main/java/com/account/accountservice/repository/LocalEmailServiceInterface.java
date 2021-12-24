package com.account.accountservice.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(name = "email-service", url = "localhost:8088")
public interface LocalEmailServiceInterface {

	@RequestMapping(method = RequestMethod.POST, value = "/send-mail-without-body")
	public ResponseEntity<String> sendMailWithoutBody();

}
