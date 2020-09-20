package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

public class Project {
	private Integer factor;
	private Float percentage;
	private String name;
	private Date endDate;
	private Date startDate;
	private Location location;
	private Float amountCollected;
	private Boolean isClosed;

	public Boolean getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}
	PropertyChangeSupport pcs = new  PropertyChangeSupport(this);

	public Project(String name, Date endDate, Date startDate, Location location, Float amount) {
		this.factor = 1000; // de 0 a $100.000
		this.percentage = 1F; // Porcentaje mínimo de cierre de proyecto: de 50% a 100%
		this.name = name;
		this.endDate = endDate;
		this.startDate = startDate;
		this.location = location;
		this.amountCollected = 0F;
		this.isClosed=false;
	}


	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Location getLocation() {
		return location;
	}

	public Float getAmountCollected() {
		return this.amountCollected;
	}

	public Integer getAmountNeeded() {
		return this.getFactor() * this.location.getPopulation();
	}

	public Float getAmountMin() {
		return this.getAmountNeeded() * this.getPercentage();
	}

	public Float getPercentageAmountcollected() {
		return this.getAmountCollected() / this.getAmountNeeded();
	}

	public Boolean isOpen() {
		Date currentDate = new Date();
		return currentDate.before(this.getEndDate()) || this.getAmountCollected() < this.getAmountMin();
	}

	@SuppressWarnings("deprecation")
	public Boolean isNextToEnd() {
		Date currentDate = new Date();
		return currentDate.getYear() == this.getEndDate().getYear()
				&& currentDate.getMonth() == this.getEndDate().getMonth();
	}

	public Integer getPopulation() {
		return this.location.getPopulation();
	}

	public void addAmount(Float amount) {
		this.amountCollected += amount;
	}


	public void addObserver(PropertyChangeListener l) {
		pcs.addPropertyChangeListener("theProperty", l);
	}

	public void setProperty(Boolean val) {
		Boolean old = this.isClosed;
		this.isClosed = val;
		pcs.firePropertyChange("theProperty", old, val);
	}
	public String toString() { return "The project object"; }


}
