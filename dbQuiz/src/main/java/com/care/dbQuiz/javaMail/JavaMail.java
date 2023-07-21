package com.care.dbQuiz.javaMail;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class JavaMail {

	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl jms = new JavaMailSenderImpl();//Impl 인터페이스를 상속받는다
		jms.setHost("smtp.gmail.com");//자바프로그램이 구글 이메일서버로 내용을 보냄
		jms.setPort(587);//smtp 프로토콜 포트번호
		jms.setUsername("os41411206@gmail.com");
		jms.setPassword("ostlkwepwrexfjzx");
		
		Properties pro = new Properties();
		pro.setProperty("mail.transport.protocol", "smtp");
		pro.setProperty("mail.smtp.auth", "true");//구글에서 인증할건지 여부
		pro.setProperty("mail.smtp.starttls.enable", "true");//암호화해서 보낼건지 여부
		jms.setJavaMailProperties(pro);
		return jms;
	}
}
