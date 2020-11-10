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
public class LocationController extends CommonController<Location, LocationService>{
	
	@GetMapping("")
    public List<Location> allLocations() {
        List<Location> list = this.service.findAll();
        return list;
    }
	
	@GetMapping("/Top10WithMoreTimeWithoutDonations")
	public List<Location> findTop10WithMoreTimeWithoutDonations(){
		return this.service.findTop10WithMoreTimeWithoutDonations();
	}
	
	@GetMapping("/locationWithOutProject")
	public List<Location> findLocationWithOut() {
		return this.service.locationWithOutProject();
	}
}
