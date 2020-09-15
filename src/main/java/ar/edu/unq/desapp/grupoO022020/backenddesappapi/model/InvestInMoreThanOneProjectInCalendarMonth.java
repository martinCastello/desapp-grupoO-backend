package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class InvestInMoreThanOneProjectInCalendarMonth implements IPointSystemState {

	@Override
	public UserDonator givePointsToUser(Donation donation) {
		UserDonator user = donation.getUser();
		user.points = 500;
		donation.setUser(user);
		return donation.getUser();
	}

}
