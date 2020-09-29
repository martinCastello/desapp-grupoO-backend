package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Transient;


@Entity
@SequenceGenerator(name = "SEQ_PROJECT", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_PROJECT")
public class Project implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROJECT")
	private Integer id;
	@Column
	private String name;
	@Column
	private Date endDate;
	@Column
	private Date startDate;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "locationId", referencedColumnName = "id")
	private Location location;
	@Column
	private Integer factor;
	@Column
	private Float percentage;
	@Column
	private Float amountCollected;
	@Column
	private Boolean isClosed;
	@Transient
	private PropertyChangeSupport pcs = new  PropertyChangeSupport(this);
	
	public Project() {}

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

	public void validationDates() throws Exception {
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
	
	public Boolean isClosed() {
		return this.isClosed;
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
	
//	public Boolean canBeClosed() {
//		return this.getEndDate().before(new Date()) && this.getAmountCollected() > this.getAmountMin();
//	}

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
	
	
}
