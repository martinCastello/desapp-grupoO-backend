package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootTest(classes = BackendDesappApiApplication.class)
class ArsatWebServiceTest {
	
	@Autowired
	private ArsatWebService arsatWebService;
	
	
	@Test
	void testConnectionWithApiArsat() throws URISyntaxException, JsonMappingException, JsonProcessingException {
//		System.out.println(arsatWebService.getLocationList());
		assertEquals(String.class, arsatWebService.getLocationList());
	}

}
