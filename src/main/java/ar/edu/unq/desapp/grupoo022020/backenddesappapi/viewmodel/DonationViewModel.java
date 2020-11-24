package ar.edu.unq.desapp.grupoo022020.backenddesappapi.viewmodel;

public class DonationViewModel {
	private Integer userId;

	private Integer projectId;

	private Float investment;

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
