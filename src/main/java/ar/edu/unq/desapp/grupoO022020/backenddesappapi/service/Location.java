package ar.edu.unq.desapp.grupoO022020.backenddesappapi.service;

public class Location {
	String name;

	String province;
	Double population;
	Boolean status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Double getPopulation() {
		return population;
	}

	public void setPopulation(Double population) {
		this.population = population;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Location(String name, String province, Double population, Boolean status) {
		this.name = name;
		this.province = province;
		this.population = population;
		this.status = status;
	}
}
