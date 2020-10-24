package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import javax.validation.Valid;

public interface CommonService<E>{

	public E save(@Valid E entity);

	

}
