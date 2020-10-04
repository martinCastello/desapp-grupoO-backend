package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories.UserDonatorRepository;

@Service
public class UserService {

	@Autowired
	private UserDonatorRepository repository;
	
	
	@Transactional
	public UserDonator save(UserDonator model) {
		return this.repository.save(model);
	}
	
	public UserDonator findByID(Integer id) {
		return this.repository.findById(id).get();
	}

	public List<UserDonator> findAll() {
		return this.repository.findAll();
	}

}
