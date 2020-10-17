package ar.edu.unq.desapp.grupoo022020.backenddesappapi.viewmodel;

import java.util.Date;

public class DonationViewModel {
	private Integer userId;

	private Integer projectId;

	private Float investment;

	public DonationViewModel(int userId, int projectId, Float invest, Date date) {
		this.setUserId(userId);
		this.setProjectId(projectId);
		this.setInvestment(invest);
	}

	public DonationViewModel() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Float getInvestment() {
		return investment;
	}

	public void setInvestment(Float investment) {
		this.investment = investment;
	}

}
