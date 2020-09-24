package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donations")
public class Donation {
	@Id
	private UserDonator user;
	@Column
	private Project project;
	@Column
	private Float investment;
	private Date date;
	
	public Donation() {
		super();
	}
	public Donation(UserDonator user, Project project, Float invest) {
		super();
		this.setProject(project);
		this.setInvestment(invest);
		this.setDate(new Date());
		this.setUser(user);
		PointCalculatorContext.givePointsToUser(this);
		project.addObserver(user);
	}

	public Project getProject() {
		return this.project;
	}

	public Float getInvestment() {
		return this.investment;
	}

	public Date getDate() {
		return this.date;
	}

	public UserDonator getUser() {
		return this.user;
	}

	public int getUserPoints() {
		return this.getUser().getPoints();
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setInvestment(Float investment) {
		this.investment = investment;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setUser(UserDonator user) {
		this.user = user;
	}

	public String getUserNameForDonator() {
		return this.getUser().getNickName();
	}

	public Integer getPoblationOfLocation() {
		return this.getProject().getPopulation();
	}

	public Float getProjectCollectedMoney() {
		return this.getProject().getAmountCollected();
	}
}
