package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Location;

@Service
public class ArsatWebService {
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	protected static final HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		// headers.set("auth key", "GQ8mVEyKqSbH5RGOtYqYrB2ihmKRwtEjXhDpjupA");
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	@Cacheable
	public List<Location> getLocationList() throws URISyntaxException, JsonMappingException, JsonProcessingException{
		RestTemplate restTemplate = new RestTemplate();
	    URI uri = URI.create("http://prod.arsat.apim.junar.com/plan-federal-de-internet/v1/puntos/conectados.json/"
	    		+ "?auth_key=GQ8mVEyKqSbH5RGOtYqYrB2ihmKRwtEjXhDpjupA");
	    HttpEntity<String> request = new HttpEntity<String>("", getHeaders());
		ResponseEntity<String> result = restTemplate.exchange(uri, 
				HttpMethod.GET, request, String.class) ;
		JsonNode root = objectMapper.readTree(result.getBody()).get("data");
		Iterator<JsonNode> rootIter = root.iterator();
		System.out.print("root *** " + root.get(0));
		rootIter.next();
		List<Location> locations = new ArrayList<Location>();
		while(rootIter.hasNext()) {
			JsonNode JsonAUsar = rootIter.next();
			System.out.println("element*** " + JsonAUsar);
			locations.add(new Location(
					JsonAUsar.get(3).textValue(),
					JsonAUsar.get(4).asText(),
					JsonAUsar.get(6).asInt(),
					JsonAUsar.get(8).asBoolean()));
		}
		System.out.println("data*** " + locations.get(0).getName() );
		return locations;
	}
}
