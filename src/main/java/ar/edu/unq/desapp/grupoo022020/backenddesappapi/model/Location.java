package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model;

public class Location {
	private String name;
	private String province;
	private Integer population;
	private Boolean isConnected;

	public Location(String name, String province, Integer population, Boolean isConnected) {
		this.setName(name);
		this.setProvince(province);
		this.setPopulation(population);
		this.setIsConnected(isConnected);
	}
	
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

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Boolean getIsConnected() {
		return isConnected;
	}

	public void setIsConnected(Boolean isConnected) {
		this.isConnected = isConnected;
	}
}
