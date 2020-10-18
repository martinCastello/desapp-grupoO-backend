package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.builder;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;

public class DonationBuilder {

	private UserDonator user = UserBuilder.createUser().buildDonator();
	private Project project;
	private Float invest = 0F;
	private Integer donations = 0;

	public static DonationBuilder createDonation() {
		return new DonationBuilder();
	}

	public Donation build() throws Exception {
		if (this.project == null)
			this.project = ProjectBuilder.createProject().build();
		return new Donation(this.user, this.project, this.invest, this.donations);
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

	public DonationBuilder withDonationInCurrentMonth(Integer donations) {
		this.donations = donations;
		return this;
	}
}
