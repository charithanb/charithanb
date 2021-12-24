package com.asb.example.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.asb.example.dto.EmailRequestDto;
import com.asb.example.dto.FileDB;
import com.asb.example.repository.FileDBRepository;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Configuration configuration;

	@Autowired
	private FileDBRepository fileDBRepository;

	public String sendMail(EmailRequestDto request, Map<String, String> model) {

		String response;
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			// ClassPathResource pdf = new ClassPathResource("static/attachment.pdf");
			ClassPathResource image = new ClassPathResource("static/westerntravellers_logo.jpg");
			Template template = configuration.getTemplate("email.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

			helper.setTo(request.getTo());
			helper.setFrom(request.getFrom());
			helper.setSubject(request.getSubject());
			helper.setText(html, true);
			helper.addInline("westerntravellers_logo", image);
			// helper.addAttachment("attachment.pdf", pdf);

			mailSender.send(message);
			response = "Email has been sent to :" + request.getTo();
		} catch (MessagingException | IOException | TemplateException e) {
			response = "Email send failure to :" + request.getTo();
		}
		return response;
	}

	public String sendMailWithoutBody(String from, String to, String subject, String name, Map<String, String> model) {
		String response;
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			// ClassPathResource pdf = new ClassPathResource("static/attachment.pdf");
			ClassPathResource image = new ClassPathResource("static/westerntravellers_logo.jpg");
			Template template = configuration.getTemplate("email.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

			helper.setTo(to);
			helper.setFrom(from);
			helper.setSubject(subject);
			helper.setText(html, true);
			helper.addInline("westerntravellers_logo", image);
			// helper.addAttachment("attachment.pdf", pdf);

			mailSender.send(message);
			response = "Email has been sent to :" + to;
		} catch (MessagingException | IOException | TemplateException e) {
			response = "Email send failure to :" + to;
		}
		return response;
	}

	public FileDB store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

		return fileDBRepository.save(FileDB);
	}

	public FileDB getFile(Long id) {
		return fileDBRepository.findById(id).get();
	}

	public void sendFileFromDb(String from, String to, String subject, String name, Map<String, String> model,
			MultipartFile fileEntity) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

		    File convertedFile = new File(fileEntity.getOriginalFilename());
		    //fileEntity.transferTo(convertedFile);
		    FileUtils.copyInputStreamToFile(fileEntity.getInputStream(), convertedFile);
			ClassPathResource image = new ClassPathResource("static/westerntravellers_logo.jpg");
			Template template = configuration.getTemplate("email.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

			helper.setTo(to);
			helper.setFrom(from);
			helper.setSubject(subject);
			helper.setText(html, true);
			helper.addInline("westerntravellers_logo", image);
		    helper.addAttachment(fileEntity.getOriginalFilename(), convertedFile);
		    
			mailSender.send(message);
		} catch (MessagingException | IOException | TemplateException e) {
			
		}
	}





}