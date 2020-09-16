package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import java.util.Date;

public class Project {
	
	private Integer factor = 1000; // de 0 a $100.000
	private Float percentage; // Porcentaje mínimo de cierre de proyecto: de 50% a 100%
	private String name;
	private Date endDate;
	private Date startDate;
	
	public Integer getFactor() {
		return factor;
	}
	public void setFactor(Integer factor) {
		this.factor = factor;
	}
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	
}
