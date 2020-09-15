package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import java.util.Date;

public class ProjectBuilder {

	private Integer factor = 1000;
	private Float percentage;
	private String name;
	private Date endDate;
	private Date startDate;
	
	public static ProjectBuilder createProject() {
		return new ProjectBuilder();
	}
	
	public ProjectBuilder withFactor(Integer newFactor) {
		this.factor = newFactor;
		return this;
	}
	
	public ProjectBuilder withPercentage(Float newPercentage) {
		this.percentage = newPercentage;
		return this;
	}
	
	public ProjectBuilder withName(String newName) {
		this.name = newName;
		return this;
	}
	
	public ProjectBuilder withEndDate(Date newEndDate) {
		this.endDate = newEndDate;
		return this;
	}
	
	public ProjectBuilder withStartDate(Date newStartDate) {
		this.startDate = newStartDate;
		return this;
	}
	
	public Project build() {
		Project project = new Project();
		project.setFactor(this.factor);
		project.setPercentage(this.percentage);
		project.setName(this.name);
		project.setEndDate(this.endDate);
		project.setStartDate(this.startDate);
		return project;
	}

}
