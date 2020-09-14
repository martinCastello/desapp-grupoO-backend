package ar.edu.unq.desapp.grupoO022020.backenddesappapi.service;

public class DonationBuider {
	public static DonationBuider createDonation() {
		return new DonationBuider();
	}
	private String user = "";
	private String project = "new project";
	private Float invest= (float) 100.50;
	
	public Donation create() {
		return new Donation(user, project, invest);
	}

	public DonationBuider withUser(String user) {
		this.user = user;
		return this;
	}
	
	public DonationBuider withProject(String project) {
		this.project = project;
		return this;
	}
	
	public DonationBuider withInvest(Float invest) {
		this.invest = invest;
		return this;
	}
}
