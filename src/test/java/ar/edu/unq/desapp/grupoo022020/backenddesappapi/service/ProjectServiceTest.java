package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.BackendDesappApiApplication;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories.ProjectRepository;

@SpringBootTest(classes = BackendDesappApiApplication.class)
class ProjectServiceTest {
	
	@Autowired
	private ProjectRepository repository;

	@Test
	void test() throws Exception {
		Date startDate = new Date();
		Date endDate = new Date(startDate.getTime()+1000);
		Location aLocation = new Location("Varela", "Buenos Aires", 200000, Boolean.FALSE);
		Project project = new Project("test", endDate, startDate, aLocation);
		repository.save(project);
		assertEquals(1, repository.findAll().size());
	}

}
