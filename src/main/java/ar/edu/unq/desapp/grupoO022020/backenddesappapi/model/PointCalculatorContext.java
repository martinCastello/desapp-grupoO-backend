package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

final class PointCalculatorContext {

	private static IPointSystemState getPointSystem(Donation donation) {
		IPointSystemState system = null;
		if (donation.getUserNameForDonator().contains("month")) {
			return new InvestInMoreThanOneProjectInCalendarMonth();
		}
		if (donation.getProjectCollectedMoney() >= 1000.00F) {
			return new InvestInProyectCollectionGreaterThanOneThousandPesos();
		}
		if (donation.getPoblationOfLocation() < 2000) {
			return new InvestInProyectWithMoreThanTwoThousandHabitants();
		}
		return system;
	}

	public static void givePointsToUser(Donation donation) {
		IPointSystemState system = getPointSystem(donation);
		if (system != null) {
			system.givePointsToUser(donation);
		}
	}

}
