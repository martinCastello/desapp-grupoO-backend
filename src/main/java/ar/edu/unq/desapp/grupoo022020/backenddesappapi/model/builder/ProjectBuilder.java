package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.builder;

import java.util.Date;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;

public class ProjectBuilder {

	private Integer factor;
	private Float percentage;
	private String name = "New Project Name";
	private Date startDate = new Date();
	private Date endDate = new Date(this.startDate.getTime() + 1000);
	private Location location = new Location("Quilmes", "Buenos Aires", 350000, Boolean.FALSE);
	private Float amountCollected;

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

	public ProjectBuilder withLocation(Location location) {
		this.location = location;
		return this;
	}

	public ProjectBuilder withAmountCollect(Float amout) {
		this.amountCollected = amout;
		return this;
	}

	public Project build() throws Exception {
		Project project = new Project(this.name, this.endDate, this.startDate, this.location);
		if (this.factor != null)
			project.setFactor(this.factor);
		if (this.percentage != null)
			project.setPercentage(this.percentage);
		if (this.amountCollected != null)
			project.addAmount(this.amountCollected);
		return project;
	}

}
