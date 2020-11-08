package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

public interface EmailService {

	void sendSimpleMessage(String to, String subject, String text);
	
}
