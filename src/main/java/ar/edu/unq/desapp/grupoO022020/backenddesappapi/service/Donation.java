package ar.edu.unq.desapp.grupoO022020.backenddesappapi.service;

import java.sql.Date;
import java.util.Calendar;

public class Donation {
	String user;
	String project;
	Float investment;
	Date date;
	
	public Donation(String user, String project, Float invest) {
		this.user= user;
		this.project = project;
		this.investment = invest;
		this.date = (Date) Calendar.getInstance().getTime();
	}
}
