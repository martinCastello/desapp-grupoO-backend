package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.EmailService;

@Component
public class EmailServiceImpl implements EmailService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Value("${spring.mail.username}")
	private static String NOREPLY_ADDRESS;
	
	@Autowired
    private JavaMailSender emailSender;
	
    public void sendSimpleMessage(String to, String subject, String text) {
    	try {
    		SimpleMailMessage message = new SimpleMailMessage(); 
            message.setFrom(NOREPLY_ADDRESS);
            message.setTo(to); 
            message.setSubject(subject); 
            message.setText(text);
            emailSender.send(message);
            LOGGER.info("Mail sent!");
    	}catch (MailException e) {
    		LOGGER.error("There was an error sending the mail: {}", e);
        }
    }
}
