package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class InvestInProyectWithMoreThanTwoThousandHabitants implements IPointSystemState {

	@Override
	public int givePointsToUser(Donation donation) {
		return (int) Math.round(donation.investment);
	}

}
