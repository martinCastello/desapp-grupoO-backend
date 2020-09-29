package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;

@Service
@Transactional
public class InitServiceInMemory {
	protected final Log logger = LogFactory.getLog(getClass());

	@Value("${spring.datasource.driverClassName:NONE}")
	private String className;
	
	@Autowired
	private ProjectService projectService;
	
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
		Date endDate = new Date(startDate.getTime()+1000);
		for(Location location : arsatWebService.getLocationsInInternetPlanningList()) {
			Project project = new Project("test", endDate, startDate, location);
			projectService.save(project);
		}
	}
}
