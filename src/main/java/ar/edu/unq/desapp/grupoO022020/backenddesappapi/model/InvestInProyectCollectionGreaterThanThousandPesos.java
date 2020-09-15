package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class InvestInProyectCollectionGreaterThanThousandPesos implements IPointSystemState {

	@Override
	public UserDonator givePointsToUser(Donation donation) {
		UserDonator user = donation.getUser();
		user.points = (int)(donation.getInvestment() * 2);
		donation.setUser(user);
		return donation.getUser();
	}

}
