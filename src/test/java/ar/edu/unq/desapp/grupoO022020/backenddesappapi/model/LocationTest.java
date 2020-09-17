package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.LocationBuilder;

public class LocationTest {

	@Test
	public void testLocationName() {
		Location newLocation = LocationBuilder.createLocation().withName("Bernal").build();
		assertEquals("Bernal", newLocation.getName());
	}

	@Test
	public void testLocationProvince() {
		Location newLocation = LocationBuilder.createLocation().withProvince("BuenosAires").build();
		assertEquals("BuenosAires", newLocation.getProvince());
	
	}

	@Test
	public void testLocationPopulation() {
		Location newLocation = LocationBuilder.createLocation().withPopulation(10000).build();
		assertEquals(10000, newLocation.getPopulation());
	}

	@Test
	public void testLocationStatus() {
		Location newLocation = LocationBuilder.createLocation().withStatus(false).build();
		assertFalse(newLocation.getIsConnected());
	}
}
