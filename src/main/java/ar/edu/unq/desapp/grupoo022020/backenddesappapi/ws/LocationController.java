package ar.edu.unq.desapp.grupoo022020.backenddesappapi.ws;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.LocationService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.viewmodel.LocationViewModel;

@RestController
@EnableAutoConfiguration
@RequestMapping("/home/locations")
@CrossOrigin(origins = "*")
public class LocationController extends CommonController<Location, LocationService>{
	
	@GetMapping("")
    public ResponseEntity<?> allLocations() {
        return ResponseEntity.ok(this.service.findAll());
    }
	
	@GetMapping("/Top10WithMoreTimeWithoutDonations")
	public ResponseEntity<?> findTop10WithMoreTimeWithoutDonations(){
		return ResponseEntity.ok(this.service.findTop10WithMoreTimeWithoutDonations());
	}
	
	@GetMapping("/locationWithOutProject")
	public ResponseEntity<?> findLocationWithOut() {
		return ResponseEntity.ok(this.service.locationWithOutProject());
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody LocationViewModel locationView) throws Exception {
		Location location = this.service.findByID(locationView.getId());
		location.setPopulation(locationView.getPopulation());
		this.service.save(location);
		return new ResponseEntity<Location>(location, HttpStatus.OK);
	}
}
