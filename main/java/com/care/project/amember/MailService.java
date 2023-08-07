package com.care.project.amember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
	@Autowired	private JavaMailSender mailSender;

	public String sendMail(String email, String title, String content, MultipartFile emailFile) {
		MimeMessage message = mailSender.createMimeMessage();
		
		String[] checkData = email.split(",");
		for(String emailData : checkData) {
			try {
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				
				messageHelper.setSubject(title); // 이메일의 제목
				messageHelper.setText(content);// 이메일의 본문
				messageHelper.setTo(emailData); // 수신자
				
				if (emailFile != null && !emailFile.isEmpty()) {
	                messageHelper.addAttachment(emailFile.getOriginalFilename(), emailFile);
	            }
				
				mailSender.send(message);
			} catch (MailSendException e) {
				e.printStackTrace();
				return "이메일 주소가 잘못된 주소 입니다";
			} catch (Exception e) {
				e.printStackTrace();
				return "이메일 전송에 문제가 발생했습니다. 잠시 후에 다시 시도 하세요.";
			}
		}
		return "전송완료.";	
	}
}