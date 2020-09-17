package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder;

import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.Location;

public class LocationBuilder {
	
	private String name; 
	private String province;
	private Long population;
	private Boolean isConnected;
	
	public static LocationBuilder createLocation() {
		return new LocationBuilder();
	}

	public Location build() {
		Location location = new Location(this.name, this.province, this.population, this.isConnected);
		return location;
	}
	public LocationBuilder withName(String aName) {
		this.name = aName;
		return this;
		
	}
	public LocationBuilder withProvince(String aProvince) {
		this.province = aProvince;
		return this;
		
	}
	public LocationBuilder withPopulation(Long aPopulation) {
		this.population = aPopulation;
		return this;
		
	}
	public LocationBuilder withStatus(Boolean isConnected) {
		this.isConnected = isConnected;
		return this;
		
	}


}
	