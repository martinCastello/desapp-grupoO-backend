package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class Location {
	private String name;
	private String province;
	private Long population;
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

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Boolean getIsConnected() {
		return isConnected;
	}

	public void setIsConnected(Boolean isConnected) {
		this.isConnected = isConnected;
	}

	public Location(String name, String province, Long population, Boolean isConnected) {
		this.setName(name);
		this.setProvince(province);
		this.setPopulation(population);
		this.setIsConnected(isConnected);
	}
}
