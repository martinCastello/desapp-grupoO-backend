package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class Location {
	private String name;
	private String province;
	private Double population;
	private Boolean isConnected;

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

	public Boolean getIsConnected() {
		return isConnected;
	}

	public void setIsConnected(Boolean status) {
		this.isConnected = status;
	}

	public Location(String name, String province, Double population, Boolean status) {
		this.setName(name);
		this.setProvince(province);
		this.setPopulation(population);
		this.setIsConnected(status);
	}
}
