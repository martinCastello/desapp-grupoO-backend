package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_LOCATION", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_LOCATION")
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOCATION")
	private Integer id;
	@Column
	private String name;
	@Column
	private String province;
	@Column
	private Integer population;
	@Column
	private Boolean isConnected;

	public Location() {
	}

	public Location(String name, String province, Integer population, Boolean isConnected) {
		super();
		this.setName(name);
		this.setProvince(province);
		this.setPopulation(population);
		this.setIsConnected(isConnected);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Boolean getIsConnected() {
		return isConnected;
	}

	public void setIsConnected(Boolean isConnected) {
		this.isConnected = isConnected;
	}

	public Integer getId() {
		return this.id;
	}
}
