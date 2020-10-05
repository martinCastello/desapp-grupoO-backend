package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repository;
	
	@Transactional
	public Project save(Project model) {
		return this.repository.save(model);
	}
	
	public Project findByID(Integer id) {
		return this.repository.findById(id).get();
	}

	public List<Project> findAll() {
		return this.repository.findAll();
	}
	
	public List<Project> findOpen() {
		return this.repository.findByIsClosed(Boolean.FALSE);
	}

}
