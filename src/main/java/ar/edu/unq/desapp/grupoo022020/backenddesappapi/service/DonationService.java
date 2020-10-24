package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories.DonationRepository;

@Service
public class DonationService {
	@Autowired
	private DonationRepository repository;

	@Transactional
	public Donation save(Donation donation) {
		var donationsMadeInCurrentMonth = this.getDonationsInCurrentMonth(donation.getUser());
		PointCalculatorContext.givePointsToUser(donation, donationsMadeInCurrentMonth.size());
		return this.repository.save(donation);
	}

	public Optional<Donation> findByID(Integer id) {
		try {
			return this.repository.findById(id);
		} catch (Exception e) {
			return Optional.empty();
		}

	}

	public List<Donation> findAll() {
		return this.repository.findAll();
	}

	public List<Donation> findByUserId(Integer userId) {
		return this.repository.findByUserId(userId);
	}

	public List<Donation> getDonationsInCurrentMonth(UserDonator user) {
		return this.repository.getDonationsMadeByUserInCurrentMonth(user);
	}
}
