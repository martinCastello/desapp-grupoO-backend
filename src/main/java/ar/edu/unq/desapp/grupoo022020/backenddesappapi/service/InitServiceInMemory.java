package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.AdminUser;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Donation;
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
	private LocationService locationService;
	
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
		
		/* Users create */
		UserDonator mariel = new UserDonator("mariel", "mariel@gmail.com", "marielNick", "pass");
		UserDonator carina = new UserDonator("carina", "carina@gmail.com", "carinaNick", "pass");
		UserDonator juana = new UserDonator("juana", "escobargisele1@gmail.com", "juanaNick", "pass");
		AdminUser administrador = new AdminUser("administrador", "administrador@gmail.com", "administradorNick", "pass");
		userDonatorService.save(mariel);
		userDonatorService.save(carina);
		userDonatorService.save(juana);
		userAdminService.save(administrador);
		
		/* locations and projects create */
		Date startDate = new Date();
		Date endDate = new Date(startDate.getTime() + 1000);
		int counter = 0;
		List<Location> locations = arsatWebService.getLocationsInInternetPlanningList();
		locationService.saveAll(locations);
		int x = (locations.size() / 2) - 1;
		for (Location location : locations.subList(0, x)) {
			Project project = new Project("Proyecto " + location.getName(), endDate, startDate, location);
			if(counter == 1) {
				project.addAmount(100000F);
				project.addObserver(juana);
				project.close();
			}
			projectService.save(project);
			counter++;
		}

		/* Donation create */
		var projects = projectService.findAll();
		var userMariel = userDonatorService.findAll().get(0);
		var userJuana = userDonatorService.findAll().get(2);
		if (projects.size() > 0) {
			Project aProject = projects.get(0);
			Donation firstDonation = new Donation(userMariel, aProject, 100.00F);
			donationService.save(firstDonation);
			Donation secondDonation = new Donation(userJuana, aProject, 199.00F);
			donationService.save(secondDonation);
			userDonatorService.save(userMariel);
			userDonatorService.save(userJuana);
			projectService.save(aProject);
		}

	}

}
