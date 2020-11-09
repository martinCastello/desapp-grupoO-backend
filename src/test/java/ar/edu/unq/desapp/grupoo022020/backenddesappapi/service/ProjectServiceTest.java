package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.BackendDesappApiApplication;

@SpringBootTest(classes = BackendDesappApiApplication.class)
class ProjectServiceTest {
	
	@Autowired
	private ProjectService service;
	

	@Test
	void givenProjectsInitServiceInMemorywhenIGetQuantityProjectsThenReturn3() throws Exception {
		assertEquals(3, service.findAll().size());
	}
	
	@Test
	void givenProjectsInitServiceInMemorywhenIGetProjectId9ThenReturnFIrst() throws Exception {
		// First register of futuros.json
		assertEquals(2231, service.findByID(1).get().getPopulation());
	}
	
	@Test
	void givenProjectsWithoutCloseAndCurrentMonthWhenIgetNextToEndThenReturn2() {
		assertTrue(service.findNextToEnd().size() == 2);
	}
	
	@Test
	void givenProjectWithTwoDonatorsWhenIgetTotalOfParticipantsThenReturn2() {
		assertTrue(service.findByID(1).get().getTotalOfParticipants() == 2);
	}

}
