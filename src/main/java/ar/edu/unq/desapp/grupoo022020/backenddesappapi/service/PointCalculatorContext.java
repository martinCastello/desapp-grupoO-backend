package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Donation;

final class PointCalculatorContext {

	private static IPointSystemState getPointSystem(Donation donation, Integer donationInMonth) {
		IPointSystemState system = null;
		if (donationInMonth > 0) {
			return new InvestInMoreThanOneProjectInCalendarMonth();
		}
		if (donation.getInvestment() >= 1000.00F) {
			return new InvestInProyectCollectionGreaterThanOneThousandPesos();
		}
		if (donation.getPoblationOfLocation() < 2000) {
			return new InvestInProyectWithMoreThanTwoThousandHabitants();
		}
		return system;
	}

	public static void givePointsToUser(Donation donation, Integer donationInMonth) {
		IPointSystemState system = getPointSystem(donation, donationInMonth);
		if (system != null) {
			system.givePointsToUser(donation);
		}
	}

}
