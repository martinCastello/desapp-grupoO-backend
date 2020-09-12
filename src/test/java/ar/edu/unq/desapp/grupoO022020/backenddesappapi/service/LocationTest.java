package ar.edu.unq.desapp.grupoO022020.backenddesappapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LocationTest {

	@Test
	public void testCreateLocation() {
		Location newLocation = LocationBuilder.createLocation().build();
		newLocation.setName("Quilmes");
		assertEquals(newLocation.name, "Quilmes");
	}

	@Test
	public void testLocationName() {
		Location newLocation = LocationBuilder.createLocation().withName("Bernal").build();
		assertEquals(newLocation.getName(), "Bernal");
	}

	@Test
	public void testLocationProvince() {
		Location newLocation = LocationBuilder.createLocation().withProvince("BuenosAires").build();
		assertEquals(newLocation.getProvince(), "BuenosAires");
	
	}

	@Test
	public void testLocationPopulation() {
		Location newLocation = LocationBuilder.createLocation().withPopulation(10.5).build();
		assertEquals(newLocation.getPopulation(), 10.5);
	}

	@Test
	public void testLocationStatus() {
		Location newLocation = LocationBuilder.createLocation().withStatus(false).build();
		assertEquals(newLocation.getStatus(), false);
	}
}
