package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder;

import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.UserDonator;

public class DonationBuider {
	public static DonationBuider createDonation() {
		return new DonationBuider();
	}

	private UserDonator user = UserBuilder.createUser().buildDonator();
	private String project = "new project";
	private Float invest = (float) 100.50;

	public Donation build() {
		return new Donation(user, project, invest);
	}

	public DonationBuider withUser(UserDonator user) {
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
