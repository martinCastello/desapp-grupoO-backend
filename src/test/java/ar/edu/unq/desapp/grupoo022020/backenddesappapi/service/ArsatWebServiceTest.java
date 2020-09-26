package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BackendDesappApiApplication.class)
class ArsatWebServiceTest {
	
	@Autowired
	private ArsatWebService arsatWebService;
	
	
	@Test
	void givenConnectionWithApiArsatWhenIGetLocationsWithInternetItsNotReturnEmpty() throws URISyntaxException, IOException {
		assertFalse(arsatWebService.getLocationWithInternetList().isEmpty());
	}
	
	@Test
	void givenConnectionWithApiArsatWhenIGetLocationsInInternetPlanningItsNotReturnEmpty() throws URISyntaxException, IOException {
		assertFalse(arsatWebService.getLocationsInInternetPlanningList().isEmpty());
	}
	
	@Test
	void givenLocationsWithInternetWhenIGetAnyMatchPopulationEquals404ItsReturnTrue() throws URISyntaxException, IOException {
		assertTrue(arsatWebService.getLocationWithInternetList().stream().anyMatch(location -> location.getPopulation()==404));
	}
	
	@Test
	void givenLocationsInInternetPlanningWhenIGetAnyMatchPopulationEquals123ItsReturnTrue() throws URISyntaxException, IOException {
		assertTrue(arsatWebService.getLocationsInInternetPlanningList().stream().anyMatch(location -> location.getPopulation()==123));
	}

}
