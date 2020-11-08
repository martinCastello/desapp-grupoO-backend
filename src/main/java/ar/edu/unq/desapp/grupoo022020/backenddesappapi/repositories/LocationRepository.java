package ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Location;

@Configuration
@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

	Optional<Location> findById(Integer id);

	List<Location> findAll();

	@Query(value = "select * from Location where id not in (select location_Id from project)", nativeQuery = true)
	List<Location> locationWithOutProject();

}
