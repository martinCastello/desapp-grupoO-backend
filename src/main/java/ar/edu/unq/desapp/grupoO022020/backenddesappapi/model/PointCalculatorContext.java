package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

abstract class PointCalculatorContext {
	private IPointSystemState system;

	public PointCalculatorContext(Donation donation) {
		if (this.getUserNameForDonator().contains("month")) {
			this.system = new InvestInMoreThanOneProjectInCalendarMonth();
		}
		if (this.project.getFactor() == 1000) {
			this.system = new InvestInProyectCollectionGreaterThanThousandPesos();
		}
		this.system = new InvestInProyectWithMoreThanTwoThousandHabitants();
	}
}
