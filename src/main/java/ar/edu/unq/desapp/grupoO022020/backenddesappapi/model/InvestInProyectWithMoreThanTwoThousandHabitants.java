package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class InvestInProyectWithMoreThanTwoThousandHabitants implements IPointSystemState {

	@Override
	public void givePointsToUser(Donation donation) {
		UserDonator user = donation.getUser();
		user.addPoints((int) (donation.getInvestment() * 2));
	}

}
