package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class InvestInProyectWithMoreThanTwoThousandHabitants implements IPointSystemState {

	@Override
	public UserDonator givePointsToUser(Donation donation) {
		UserDonator user = donation.getUser();
		user.points = (int) Math.round(donation.getInvestment());
		donation.setUser(user);
		return donation.getUser();
	}

}
