package ar.edu.unq.desapp.grupoO022020.backenddesappapi.service;

public class PointSystemContext {
	private IPointSystemStrategy system;
	
	public PointSystemContext(IPointSystemStrategy system) {
		this.system = system;
	}
	
	public int executeStrategy(Donation donation){
	      return system.givePointsToUser(donation);
	}
}
