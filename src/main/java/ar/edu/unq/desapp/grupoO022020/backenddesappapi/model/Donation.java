package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import java.util.*;

public class Donation {
	private UserDonator user;
	private String project;
	private Float investment;
	private Date date;
	private IPointSystemState pointSystemState;
	
	public Donation(UserDonator user, String project, Float invest) {
		this.project = project;
		this.investment = invest;
		this.date = new Date();
		this.user= user;
		this.pointSystemState= getStateForDonation();
		this.user= this.pointSystemState.givePointsToUser(this);
	}
	
	//region GETTERS
	
	public String getProject() {
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
		return this.getUser().points; //hacer getters y setters en usuario
	}
	
	//endregion


	//region SETTERS
	
	public void setProject(String project) {
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
	
	//endregion
	
	//region Private
	
	private IPointSystemState getStateForDonation() {		
		if(this.getUserNameForDonator().contains("month")) {
			return new InvestInMoreThanOneProjectInCalendarMonth();
		}
		if(this.project.contains("1000pesos")) {
			return new InvestInProyectCollectionGreaterThanThousandPesos();
		}
		return new InvestInProyectWithMoreThanTwoThousandHabitants();
	}
	
	//endregion
	
	//region PUBLIC
	
	public String getUserNameForDonator() {
		return this.user.nickName;
	}
	
	//endregion
}
