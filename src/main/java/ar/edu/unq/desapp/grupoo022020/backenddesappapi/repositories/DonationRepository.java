package ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;

@Configuration
@Repository
public interface DonationRepository extends CrudRepository<Donation, Integer> {

	Optional<Donation> findById(Integer id);

	List<Donation> findAll();

	List<Donation> findByUserId(Integer userId);

	@Query("select d from Donation d where d.user = ?1 and year(d.date) = year(CURRENT_DATE) and month(d.date) =  month(CURRENT_DATE)")
	List<Donation> getDonationsMadeByUserInCurrentMonth(UserDonator user);

}
