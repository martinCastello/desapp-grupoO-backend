package ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Donation;



@Configuration
@Repository
public interface DonationRepository extends CrudRepository<Donation, Integer> {

	Optional<Donation> findById(Integer id);
	
	List<Donation> findAll();

}


