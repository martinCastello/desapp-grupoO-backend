package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import java.sql.Date;
import java.util.Calendar;

public class Donation {
	String user;
	String project;
	Float investment;
	Date date;
	IPointSystemState pointSystemState;
	
	public Donation(String user, String project, Float invest) {
		this.project = project;
		this.investment = invest;
		this.date = (Date) Calendar.getInstance().getTime();
		this.pointSystemState= getStateForDonation();
		user += "acumula" + this.pointSystemState.givePointsToUser(this);
		this.user= user;
	}
	private IPointSystemState getStateForDonation() {
		if(this.user.contains("month")) {
			return new InvestInMoreThanOneProjectInCalendarMonth();
		}
		if(this.project.contains("1000pesos")) {
			return new InvestInProyectCollectionGreaterThanThousandPesos();
		}
		return new InvestInProyectWithMoreThanTwoThousandHabitants();
	}
}
