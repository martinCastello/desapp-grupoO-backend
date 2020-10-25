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

	@Query(value = "select u.* from user_donator u join "
			+ "(select top 10 d.user_donator_id userId, sum(d.investment) invest from donation d group by userId"
			+ " order by invest desc) rankingUser on u.id=rankingUser.userId;", nativeQuery = true)
	List<UserDonator> getTopTeenDonators();
	
}
