package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArsatWebService {
	
	protected static final HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	public ResponseEntity<?> getLocationList() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
	    URI uri;
	    uri = new URI("http://prod.arsat.apim.junar.com/plan-federal-de-internet/v1/puntos/conectados.json?auth_key=GQ8mVEyKqSbH5RGOtYqYrB2ihmKRwtEjXhDpjupA");
	    // HttpHeaders headers = new HttpHeaders();
	    // headers.set("auth_key", "GQ8mVEyKqSbH5RGOtYqYrB2ihmKRwtEjXhDpjupA");
	    // headers.setContentType(MediaType.APPLICATION_JSON);
	    // HttpEntity<String> request = new HttpEntity<String>(headers);
	    HttpEntity<String> request = new HttpEntity<>("", getHeaders());
		ResponseEntity<?> result = restTemplate.exchange(uri, 
				HttpMethod.GET, request, String.class);
		return result;
	}
}
