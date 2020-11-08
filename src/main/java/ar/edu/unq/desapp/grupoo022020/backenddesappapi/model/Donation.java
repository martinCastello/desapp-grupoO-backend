package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name = "SEQ_DONATION", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_DONATION")
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DONATION")
	private Integer id;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "userDonatorId", referencedColumnName = "id")
	private UserDonator user;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "projectId", referencedColumnName = "id")
	private Project project;
	@Column
	private Float investment;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;

	public Donation() {
	}

	public Donation(UserDonator user, Project project, Float invest) {
		super();
		this.setProject(project);
		this.setInvestment(invest);
		this.setDate(new Date());
		this.setUser(user);
		project.addObserver(user);
		project.addAmount(invest);
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

	@JsonIgnore
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

	@JsonIgnore
	public String getUserNameOfDonator() {
		return this.getUser().getNickName();
	}

	@JsonIgnore
	public Integer getPoblationOfLocation() {
		return this.getProject().getPopulation();
	}

	@JsonIgnore
	public Float getProjectCollectedMoney() {
		return this.getProject().getAmountCollected();
	}

	public Integer getId() {
		return this.id;
	}
}
