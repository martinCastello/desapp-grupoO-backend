package ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

	Optional<Project> findById(Integer id);
	
	List<Project> findAll();
	
	List<Project> findByIsClosed(Boolean isClosed);

}
