package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.CommonService;

public class CommonServiceImpl<E, R extends CrudRepository<E, Integer>> implements CommonService<E> {

	@Autowired
	protected R repository;
	
	@Transactional
	public E save(@Valid E entity) {
		return this.repository.save(entity);
	}
	
	@Transactional
	public Iterable<E> saveAll(List<E> entities) {
		return this.repository.saveAll(entities);
	}

}
