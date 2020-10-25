package ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;

@Configuration
@Repository
public interface UserDonatorRepository extends CrudRepository<UserDonator, Integer> {
	Optional<UserDonator> findById(Integer id);

	List<UserDonator> findAll();

	UserDonator findByMail(String mail);

	Optional<UserDonator> findByNickName(String userName);

	@Query(value = "select u from UserDonator where u.id in"
			+ " (Select Top 10 user_id  From (select d.user_id, max(d.date) last_date from Donation d group by d.user_id "
			+ "union all" + " select uNew.id as user_id, uNew.start_date last_date from "
			+ "(select * from UserDonator u where u.id not in (select distinct(d.user_id) "
			+ "from Donation d group by d.user_id)) uNew order by last_date));", nativeQuery = true)

	List<UserDonator> getTopTeenDonators();

}
