package ar.edu.unq.desapp.grupoo022020.backenddesappapi.jobs;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.EmailService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.LocationService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.UserService;

@Component
public class SendMailJob {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SendMailJob.class);
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LocationService locationService;
	
	@Scheduled(cron = "0 0 10 * * ?")
	public void sendSimpleMessage() {
		List<String> top10Donators = userService.getRankingDonators().stream().map(u -> u.getNickName()).collect(Collectors.toList());
		List<String> top10Locations = locationService.findTop10WithMoreTimeWithoutDonations().stream().map(l -> l.getName()).collect(Collectors.toList());
		LOGGER.info("sendSimpleMessage");
		for(UserDonator user : userService.findAll()) {
			emailService.sendSimpleMessage(user.getMail(), "top 10 de donadores", top10Donators.toString());
			emailService.sendSimpleMessage(user.getMail(), "top 10 de localidades sin recibir donaciones", top10Locations.toString());
		}
    }
	
}
