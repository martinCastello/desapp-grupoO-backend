package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BackendDesappApiApplication.class)
class ArsatWebServiceTest {
	
	@Autowired
	ArsatWebService arsatWebService;
	
	@Test
	void test_connectionWithApiArsat() throws URISyntaxException {
		System.out.println(arsatWebService.getLocationList());
		assertEquals(200, arsatWebService.getLocationList().getStatusCodeValue());
	}

}
