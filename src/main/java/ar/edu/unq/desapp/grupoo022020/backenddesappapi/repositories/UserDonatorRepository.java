package ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;

@Configuration
@Repository
public interface UserDonatorRepository extends CrudRepository<UserDonator, Integer> {
	Optional<UserDonator> findById(Integer id);

	List<UserDonator> findAll();

	UserDonator findByMail(String mail);

	UserDonator findByNickName(String userName);

}
