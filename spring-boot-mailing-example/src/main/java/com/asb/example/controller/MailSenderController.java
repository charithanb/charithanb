package com.asb.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.asb.example.dto.EmailRequestDto;
import com.asb.example.dto.FileDB;
import com.asb.example.dto.ResponseMessage;
import com.asb.example.service.MailService;

@RestController
public class MailSenderController {

	@Autowired
	private MailService mailService;

	@Autowired
	private EmailRequestDto emailRequest;

	@PostMapping("/send-mail")
	public ResponseEntity<String> sendMail(@RequestBody EmailRequestDto emailRequest) {
		Map<String, String> model = new HashMap<>();
		model.put("name", emailRequest.getName());
		model.put("value", "Western Travellers!!");
		String response = mailService.sendMail(emailRequest, model);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/send-mail-without-body")
	public ResponseEntity<String> sendMailWithoutRequestBody() {
		String from = emailRequest.setFrom("charithachowdari@gmail.com");
		String to = emailRequest.setTo("charithachowdari@gmail.com");
		String subject = emailRequest.setSubject("Westren Travellers..");
		String name = emailRequest.setName("Charitha");
		Map<String, String> model = new HashMap<>();
		model.put("name", emailRequest.getName());
		model.put("value", "Western Travellers!!");
		String response = mailService.sendMailWithoutBody(from, to, subject, name, model);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/*
	 * @PostMapping("/upload") public ResponseEntity<ResponseMessage>
	 * uploadFile(@RequestParam("file") MultipartFile file) { String message = "";
	 * try { FileDB fileEntity = mailService.store(file);
	 * 
	 * message = "Uploaded the file successfully: " + file.getOriginalFilename();
	 * return ResponseEntity.status(HttpStatus.OK).body(new
	 * ResponseMessage(message)); } catch (Exception e) { message =
	 * "Could not upload the file: " + file.getOriginalFilename() + "!"; return
	 * ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new
	 * ResponseMessage(message)); } }
	 */

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			FileDB fileEntity = mailService.store(file);

			String from = emailRequest.setFrom("charithachowdari@gmail.com");
			String to = emailRequest.setTo("charithachowdari@gmail.com");
			String subject = emailRequest.setSubject("Westren Travellers..");
			String name = emailRequest.setName("Charitha");
			Map<String, String> model = new HashMap<>();
			model.put("name", emailRequest.getName());
			model.put("value", "Western Travellers!!");
			mailService.sendFileFromDb(from, to, subject, name, model, file);
			
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		FileDB fileDB = mailService.getFile(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
	}
}