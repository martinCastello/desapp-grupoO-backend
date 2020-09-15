package ar.edu.unq.desapp.grupoO022020.backenddesappapi.service;

public class InvestInProyectCollectionGreaterThanThousandPesos implements IPointSystemState {

	@Override
	public int givePointsToUser(Donation donation) {
		return (int) (donation.investment * 2);
	}

}
