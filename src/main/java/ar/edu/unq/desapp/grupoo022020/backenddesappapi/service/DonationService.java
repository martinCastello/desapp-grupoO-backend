package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories.DonationRepository;

@Service
public class DonationService {
	private DonationRepository repository;

	@Transactional
	public Donation save(Donation model) {
		return this.repository.save(model);
	}

	public Donation findByID(Integer id) {
		return this.repository.findById(id).get();
	}

	public List<Donation> findAll() {
		return this.repository.findAll();
	}

	public List<Donation> findByUser(UserDonator user) {
		return this.repository.findByUser(user);
	}
}
