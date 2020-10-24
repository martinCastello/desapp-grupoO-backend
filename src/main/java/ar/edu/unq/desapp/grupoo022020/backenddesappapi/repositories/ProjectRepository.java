package ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

	Optional<Project> findById(Integer id);
	
	List<Project> findAll();
	
	List<Project> findByIsClosed(Boolean isClosed);

	@Query(value="select * from Project p where p.id in\n" + 
			"(select top 10 project_id from(select d.project_id, max(d.date) last_date from Donation d group by d.project_id\n" + 
			"union all\n" + 
			"select pNew.id as project_id, pNew.start_date last_date from (select * from project p where p.id not in (select distinct(d.project_id) from Donation d group by d.project_id)) pNew\n" + 
			"order by last_date));", nativeQuery=true)
	List<Project> findTop10WithMoreTimeWithoutDonations();
	
	List<Project> findByIsClosedFalseAndEndDateBetween(Date initialMonth, Date finalMonth);
	
	List<Project> findByIsClosedFalseOrderByEndDate();
	
	List<Project> findByIdNotIn(List<Integer> ids);
	
}
