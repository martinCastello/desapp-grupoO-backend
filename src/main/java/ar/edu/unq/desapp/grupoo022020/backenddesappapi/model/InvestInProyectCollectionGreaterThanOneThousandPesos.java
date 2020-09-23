package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model;

public class InvestInProyectCollectionGreaterThanOneThousandPesos implements IPointSystemState {

	@Override
	public void givePointsToUser(Donation donation) {
		UserDonator user = donation.getUser();
		user.setPoints(user.getPoints() + (int) Math.round(donation.getInvestment()));
	}

}
