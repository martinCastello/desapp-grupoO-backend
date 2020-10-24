package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;

public class InvestInMoreThanOneProjectInCalendarMonth implements IPointSystemState {

	@Override
	public void givePointsToUser(Donation donation) {
		UserDonator user = donation.getUser();
		user.addPoints(500);
	}

}
