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
	
	@Query(value="select l.* from Location l inner join Project p on l.id = p.location_id where p.id in\n" + 
			"(select top 10 project_id from(select d.project_id, max(d.date) last_date from Donation d group by d.project_id\n" + 
			"union all\n" + 
			"select pNew.id as project_id, pNew.start_date last_date from (select * from project p where p.id not in (select distinct(d.project_id) from Donation d group by d.project_id)) pNew\n" + 
			"order by last_date));", nativeQuery=true)
	List<Location> findTop10WithMoreTimeWithoutDonations();
	
	@Query(value = "select * from Location where id not in (select location_Id from Project)", nativeQuery = true)
	List<Location> locationWithOutProject();

}
