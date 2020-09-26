package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import static org.junit.jupiter.api.Assertions.assertFalse;

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

}
