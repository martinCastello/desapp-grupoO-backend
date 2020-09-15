package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class InvestInMoreThanOneProjectInCalendarMonth implements IPointSystemState {

	@Override
	public void givePointsToUser(Donation donation) {
		UserDonator user = donation.getUser();
		user.points = 500;
	}

}
