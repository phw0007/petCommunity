package com.care.dbQuiz.javaMail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired	private JavaMailSender mailSender;

	public String sendMail(String to, String subject, String content) {
		MimeMessage message = mailSender.createMimeMessage(); //메일을 송신하기위해 작성

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			//true는 멀티파트 메세지를 사용하겠다는 의미입니다.(파일첨부)
			
			messageHelper.setSubject(subject); // 이메일의 제목
			messageHelper.setText(content);// 이메일의 본문
			messageHelper.setTo(to); // 수신자

			mailSender.send(message); //메세지전송
		} catch (MailSendException e) {
			e.printStackTrace();
			return "이메일 주소가 잘못된 주소 입니다";
		} catch (Exception e) {
			e.printStackTrace();
			return "이메일 전송에 문제가 발생했습니다. 잠시 후에 다시 시도 하세요.";
		}
		return "입력한 이메일에서 인증번호를 확인하세요.";
	}
}

