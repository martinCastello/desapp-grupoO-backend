package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.io.FileReader;
import java.io.IOException;
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
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Location;

@Service
public class ArsatWebService {
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	protected static final HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
	
	private List<Location> getLocations(Iterator<JsonNode> data, int indexName, 
			int indexProvince, int indexPopulation, Boolean isConnected){
		List<Location> locations = new ArrayList<Location>();
		while(data.hasNext()) {
			JsonNode jsonLocation = data.next();
			locations.add(new Location(
					jsonLocation.get(indexName).textValue(),
					jsonLocation.get(indexProvince).asText(),
					jsonLocation.get(indexPopulation).asInt(),
					isConnected));
		}
		return locations;
	}

	@Cacheable("locationWithInternet")
	public List<Location> getLocationWithInternetList() throws URISyntaxException, IOException{
		RestTemplate restTemplate = new RestTemplate();
	    URI uri = URI.create("http://prod.arsat.apim.junar.com/plan-federal-de-internet/v1/puntos/conectados.json/"
	    		+ "?auth_key=GQ8mVEyKqSbH5RGOtYqYrB2ihmKRwtEjXhDpjupA");
	    HttpEntity<String> request = new HttpEntity<String>("", getHeaders());
	    JsonNode root;
	    try {
	    	ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
	    	root = objectMapper.readTree(result.getBody());
	    }catch (HttpServerErrorException e) {
	    	FileReader file = new FileReader("./src/main/resources/conectados.json");
	    	// String text = new String(Files.readAllBytes(Paths.get("./src/main/resources/conectados.json")), StandardCharsets.UTF_8);
	    	root = objectMapper.readTree(file); // (file, JsonNode.class);
	    }
	    Iterator<JsonNode> data = root.get("data").iterator();
	    data.next();
	    return this.getLocations(data, 3, 4, 6, Boolean.TRUE);
	}
	
	@Cacheable("locationsInInternetPlanning")
	public List<Location> getLocationsInInternetPlanningList() throws URISyntaxException, IOException{
		RestTemplate restTemplate = new RestTemplate();
	    URI uri = URI.create("http://prod.arsat.apim.junar.com/plan-federal-de-internet/v1/puntos/futuros.json/"
	    		+ "?auth_key=GQ8mVEyKqSbH5RGOtYqYrB2ihmKRwtEjXhDpjupA");
	    HttpEntity<String> request = new HttpEntity<String>("", getHeaders());
	    JsonNode root;
	    try {
	    	ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
	    	root = objectMapper.readTree(result.getBody());
	    }catch (HttpServerErrorException e) {
	    	FileReader file = new FileReader("./src/main/resources/futuros.json");
	    	root = objectMapper.readTree(file);
	    }
	    Iterator<JsonNode> data = root.get("data").iterator();
		return this.getLocations(data, 2, 3, 5, Boolean.FALSE);
	}
}
