package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.util.List;
import java.util.Optional;

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

	public Optional<UserDonator> findByID(Integer id) {
		try {
			return this.repository.findById(id);
		} catch (Exception e) {
			return Optional.empty();
		}

	}

	public List<UserDonator> findAll() {
		return this.repository.findAll();
	}

	public boolean exist(String userName, String mail) {
		var existWithUserName = this.findByNickName(userName) != null;
		var existWithMail = this.repository.findByMail(mail) != null;

		return existWithMail || existWithUserName;
	}

	public UserDonator findByNickName(String userName) {
		return this.repository.findByNickName(userName);
	}

}
