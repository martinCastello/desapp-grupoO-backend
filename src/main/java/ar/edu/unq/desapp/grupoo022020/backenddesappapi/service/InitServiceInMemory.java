package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.AdminUser;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;

@Service
@Transactional
public class InitServiceInMemory {
	protected final Log logger = LogFactory.getLog(getClass());

	@Value("${spring.datasource.driverClassName:NONE}")
	private String className;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserService userDonatorService;

	@Autowired
	private DonationService donationService;

	@Autowired
	private UserAdminService userAdminService;

	@Autowired
	private ArsatWebService arsatWebService;

	@PostConstruct
	public void initialize() throws Exception {
		if (className.equals("org.h2.Driver")) {
			logger.warn("Init Data Using H2 DB");
			fireInitialData();
		}
	}

	private void fireInitialData() throws Exception {
		Date startDate = new Date();
		Date endDate = new Date(startDate.getTime() + 1000);

		for (Location location : arsatWebService.getLocationsInInternetPlanningList()) {
			Project project = new Project("test", endDate, startDate, location);
			projectService.save(project);

		}

		UserDonator mariel = new UserDonator("mariel", "mariel@gmail.com", "marielNick", "pass");

		UserDonator carina = new UserDonator("carina", "carina@gmail.com", "carinaNick", "pass");

		UserDonator juana = new UserDonator("juana", "juana@gmail.com", "juanaNick", "pass");

		AdminUser renata = new AdminUser("carina", "carina@gmail.com", "carinaNick", "pass");

//		userDonatorService.save(mariel);
//		userDonatorService.save(carina);
//		userDonatorService.save(juana);
//		userAdminService.save(renata);
//
//		var projects = projectService.findAll();
//		var userMariel = userDonatorService.findAll().get(0);
//		var userJuana = userDonatorService.findAll().get(2);
//
//		if (projects.size() > 0) {
//			Project aProject = projects.get(0);
//
//			Donation firstDonation = new Donation(userMariel, aProject, 100.00F);
//			donationService.save(firstDonation);
//			Donation secondDonation = new Donation(userJuana, aProject, 199.00F);
//			donationService.save(secondDonation);
//
//		}

	}

}
