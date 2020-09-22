package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Calendar;
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
	private PropertyChangeSupport pcs = new  PropertyChangeSupport(this);

	public Project(String name, Date endDate, Date startDate, Location location) throws Exception {
		this.factor = 1000; // de 0 a $100.000
		this.percentage = 1F; // Porcentaje mínimo de cierre de proyecto: de 50% a 100%
		this.name = name;
		this.endDate = endDate;
		this.startDate = startDate;
		this.location = location;
		this.amountCollected = 0F;
		this.isClosed = false;
		this.validationDates();
	}

	private void validationDates() throws Exception {
		if(this.getStartDate().after(this.getEndDate()))
			throw new Exception("Inconsistency in dates");
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

	public Boolean isNextToEnd() {
		Calendar currentDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(this.getEndDate());
		return currentDate.get(Calendar.YEAR) == endDate.get(Calendar.YEAR)
				&& currentDate.get(Calendar.MONTH) == endDate.get(Calendar.MONTH);
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

	public void close() {
		Boolean old = this.isClosed;
		this.isClosed = true;
		pcs.firePropertyChange("theProperty", old, this.isClosed);
	}
	
	public Boolean getIsClosed() {
		return this.isClosed;
	}

}
