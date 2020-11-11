package ar.edu.unq.desapp.grupoo022020.backenddesappapi.viewmodel;

import java.util.Date;

public class ProjectViewModel {
	private Integer projectId;

	private Integer locationId;

	private String name;

	private Date startDate;

	private Date endDate;
	
	private Integer factor;

	public ProjectViewModel(int locationId, int projectId, String name, Date startDate, Date endDate) {
		this.setLocationId(locationId);
		this.setProjectId(projectId);
		this.setEndDate(endDate);
		this.setName(name);
		this.setStartDate(startDate);
	}

	public ProjectViewModel() {
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer userId) {
		this.locationId = userId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}

}
