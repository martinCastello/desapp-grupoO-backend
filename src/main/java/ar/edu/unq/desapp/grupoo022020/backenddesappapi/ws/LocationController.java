package ar.edu.unq.desapp.grupoo022020.backenddesappapi.ws;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.LocationService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/home/locations")
public class LocationController {

	private LocationService service;
	
	@GetMapping("")
    public List<Location> allLocations() {
        List<Location> list = service.findAll();
        return list;
    }
}
