package ar.edu.unq.desapp.grupoO022020.backenddesappapi.service;

public class InvestInProyectWithMoreThanTwoThousandHabitants implements IPointSystemState {

	@Override
	public int givePointsToUser(Donation donation) {
		return (int) Math.round(donation.investment);
	}

}
