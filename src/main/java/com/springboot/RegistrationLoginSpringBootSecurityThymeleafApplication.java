package com.springboot;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
 
import com.springboot.model.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSender;
import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
public class RegistrationLoginSpringBootSecurityThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationLoginSpringBootSecurityThymeleafApplication.class, args);
	}
	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendEmail(Mail mail) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail.getEmail());

        msg.setSubject(mail.getObjet());
        msg.setText(mail.getText());

        javaMailSender.send(msg);

    }
}
