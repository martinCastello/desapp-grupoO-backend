package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories.LocationRepository;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.impl.CommonServiceImpl;

@Service
public class LocationService extends CommonServiceImpl<Location, LocationRepository> {
	
	public Location findByID(Integer id) {
		return this.repository.findById(id).get();
	}

	public List<Location> findAll() {
		return this.repository.findAll();
	}
	
	public List<Location> findTop10WithMoreTimeWithoutDonations(){
		return this.repository.findTop10WithMoreTimeWithoutDonations();
	}
	
	public List<Location> locationWithOutProject() {
		return this.repository.locationWithOutProject();
	}
}
