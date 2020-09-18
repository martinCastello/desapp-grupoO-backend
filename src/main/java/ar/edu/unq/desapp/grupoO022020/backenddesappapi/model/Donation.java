package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import java.util.Date;

public class Donation {
	private UserDonator user;
	private Project project;
	private Float investment;
	private Date date;
	private PointCalculatorContext pointCalculator;

	public Donation(UserDonator user, Project project, Float invest) {
		this.setProject(project);
		this.setInvestment(invest);
		this.setDate(new Date());
		this.setUser(user);
		PointCalculatorContext.givePointsToUser(this);
	}

	public Project getProject() {
		return this.project;
	}

	public Float getInvestment() {
		return this.investment;
	}

	public Date getDate() {
		return this.date;
	}

	public UserDonator getUser() {
		return this.user;
	}

	public int getUserPoints() {
		return this.getUser().points;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setInvestment(Float investment) {
		this.investment = investment;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setUser(UserDonator user) {
		this.user = user;
	}

	public String getUserNameForDonator() {
		return this.user.getNickName();
	}

	public Integer getPoblationOfLocation() {
		return this.project.getPopulation();
	}

	public Float getProjectCollectedMoney() {
		return this.project.getAmountCollected();
	}
}
