package com.springboot.repository;
import com.springboot.model.Mail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, String>{

}
