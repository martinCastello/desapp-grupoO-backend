package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class LocationBuilder {
	
	private String name; 
	private String province;
	private Double population;
	private Boolean status;
	
	public static LocationBuilder createLocation() {
		return new LocationBuilder();
	}

	public Location build() {
		Location location = new Location(name, province, population, status);
		return location;
	}
	public LocationBuilder withName(final String aName) {
		name = aName;
		return this;
		
	}
	public LocationBuilder withProvince(final String aProvince) {
		province = aProvince;
		return this;
		
	}
	public LocationBuilder withPopulation(final Double aPopulation) {
		population = aPopulation;
		return this;
		
	}
	public LocationBuilder withStatus(final Boolean aStatus) {
		status = aStatus;
		return this;
		
	}


}
	