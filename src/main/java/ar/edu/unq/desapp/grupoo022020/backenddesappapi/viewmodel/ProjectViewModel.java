package ar.edu.unq.desapp.grupoo022020.backenddesappapi.viewmodel;

import java.util.Date;

public class ProjectViewModel {
	private Integer projectId;

	private Integer locationId;

	private String name;

	private String startDate;

	private String endDate;
	
	private Integer factor;

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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}

}
