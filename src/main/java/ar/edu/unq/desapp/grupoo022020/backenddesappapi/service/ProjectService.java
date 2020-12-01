package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories.ProjectRepository;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.impl.CommonServiceImpl;

@Service
public class ProjectService extends CommonServiceImpl<Project, ProjectRepository>{
	
	public Optional<Project> findByID(Integer id) {
		return this.repository.findById(id);
	}

	public List<Project> findAll() {
		return this.repository.findAll();
	}
	
	public List<Project> findOpen() {
		return this.repository.findByIsClosed(Boolean.FALSE);
	}
	
//	public List<Project> findTop10WithMoreTimeWithoutDonations(){
//		return this.repository.findTop10WithMoreTimeWithoutDonations();
//	}
	
	public List<Project> findNextToEnd(){
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(Calendar.DAY_OF_MONTH, 1);
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);
		currentDate.set(Calendar.MILLISECOND, 0);
		Date initialCurrentMonth = currentDate.getTime();
		currentDate.set(Calendar.DAY_OF_MONTH, currentDate.getActualMaximum(Calendar.DAY_OF_MONTH));
		currentDate.set(Calendar.HOUR_OF_DAY, 23);
		currentDate.set(Calendar.MINUTE, 59);
		currentDate.set(Calendar.SECOND, 59);
		currentDate.set(Calendar.MILLISECOND, 999);
		Date finalCurrentMonth = currentDate.getTime();
		return this.repository.findByIsClosedFalseAndEndDateBetween(initialCurrentMonth, finalCurrentMonth);
	}

	public List<Project> findByIdNotIn(List<Integer> ids){
		return this.repository.findByIdNotIn(ids);
	}
	
	public Boolean existProjectWithLocation(Integer id) {
		return this.repository.findByLocationId(id).isPresent();
	}
}
