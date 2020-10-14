package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	LocationRepository repository;
	
	@Autowired 
	ProjectService projectService;
	
	@Transactional
	public Location save(Location model) {
		return this.repository.save(model);
	}
	
	public Location findByID(Integer id) {
		return this.repository.findById(id).get();
	}

	public List<Location> findAll() {
		return this.repository.findAll();
	}
	
	public List<Location> findTop10WithMoreTimeWithoutDonations(){
		return projectService.findTop10WithMoreTimeWithoutDonations().stream()
				.map(p -> p.getLocation()).collect(Collectors.toList());
	}
}
