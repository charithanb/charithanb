package com.asb.example.dto;

import org.springframework.stereotype.Component;

@Component
public class EmailRequestDto {

	private String from;
	private String to;
	private String subject;
	private String name;
	public String getFrom() {
		return from;
	}
	public String setFrom(String from) {
		return this.from = from;
	}
	public String getTo() {
		return to;
	}
	public String setTo(String to) {
		return this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public String setSubject(String subject) {
		return this.subject = subject;
	}
	public String getName() {
		return name;
	}
	public String setName(String name) {
		return this.name = name;
	}
}