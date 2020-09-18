package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder;

import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.UserDonator;

public class DonationBuilder {
	public static DonationBuilder createDonation() {
		return new DonationBuilder();
	}

	private UserDonator user = UserBuilder.createUser().buildDonator();
	private Project project = ProjectBuilder.createProject().build();
	private Float invest = 0F;

	public Donation build() {
		return new Donation(user, project, invest);
	}

	public DonationBuilder withUser(UserDonator user) {
		this.user = user;
		return this;
	}

	public DonationBuilder withProject(Project project) {
		this.project = project;
		return this;
	}

	public DonationBuilder withInvest(Float invest) {
		this.invest = invest;
		return this;
	}
}
