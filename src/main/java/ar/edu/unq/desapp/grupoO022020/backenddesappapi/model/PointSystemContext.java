package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class PointSystemContext {
	private IPointSystemState system;
	
	public PointSystemContext(IPointSystemState system) {
		this.system = system;
	}
	
	public int executeStrategy(Donation donation){
	      return system.givePointsToUser(donation);
	}
}
