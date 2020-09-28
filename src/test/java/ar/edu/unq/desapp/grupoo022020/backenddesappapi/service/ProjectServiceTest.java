package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.BackendDesappApiApplication;

@SpringBootTest(classes = BackendDesappApiApplication.class)
class ProjectServiceTest {
	
	@Autowired
	private ProjectService service;
	

	@Test
	void givenProjectsInitServiceInMemorywhenIGetQuantityProjectsThenReturn9() throws Exception {
	
		assertEquals(9, service.findAll().size());
	}
	
	@Test
	void givenProjectsInitServiceInMemorywhenIGetProjectId9ThenReturnLast() throws Exception {
		// Last register of futuros.json
		assertEquals(6829, service.findByID(9).getPopulation());
	}

}
