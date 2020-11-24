package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.AdminUser;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories.AdminUserRepository;

@Service
public class UserAdminService {

	@Autowired
	private AdminUserRepository repository;

	@Transactional
	public AdminUser save(AdminUser model) {
		return this.repository.save(model);
	}

	public AdminUser findByID(Integer id) {
		return this.repository.findById(id).get();
	}

	public List<AdminUser> findAll() {
		return this.repository.findAll();
	}

	public Optional<AdminUser> findByNickName(String nickName) {
		return this.repository.findByNickName(nickName);
	}

	public Optional<AdminUser> findByMail(String mail) {
		return this.repository.findByMail(mail);
	}
	
	public boolean exist(String userName, String mail) {
		return this.findByNickName(userName).isPresent() || this.repository.findByMail(mail).isPresent();
	}

}
