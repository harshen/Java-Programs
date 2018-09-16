package com.example.spring5tutorial.controllers;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring5tutorial.mail.MailSender;
import com.example.spring5tutorial.mail.MockMailSender;

@RestController
public class MailController {

	//@Autowired
	private MailSender mailSender;
	
	/*@Autowired
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}*/
	
	/*@Autowired
	public MailController(MailSender mailSender) {
		this.mailSender = mailSender;
	}*/

	/*public MailController(@Qualifier("smtpMailSender") MailSender smtp) {
		this.mailSender = smtp;
	} */
	
	public MailController(MailSender smtp) {
		this.mailSender = smtp;
	} 
	
	@RequestMapping("/mail")
	public String mail() throws MessagingException {
		mailSender.send("kane321xyz@gmail.com", "A test mail", "Body of the test mail");
		return "Mail sent";
	}
}
