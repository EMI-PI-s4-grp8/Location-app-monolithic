package com.springboot.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// mail
	@Column(name = "id")
	private Long id ;
	@NotEmpty
	private Long clientId ;
	@NotEmpty
	private Long logementId ;
	@NotEmpty
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date arrival_date ; 
	@NotEmpty
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date departure_date ; 
	@NotEmpty
	private Long number_of_people ;
	
	
	
	public Reservation() {
		super();
	}



	public Reservation(Long clientId, Long logementId, Date arrival_date, Date departure_date, Long number_of_people) {
		super();
		this.clientId = clientId;
		this.logementId = logementId;
		this.arrival_date = arrival_date;
		this.departure_date = departure_date;
		this.number_of_people = number_of_people;
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getClientId() {
		return clientId;
	}



	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}



	public Long getLogementId() {
		return logementId;
	}



	public void setLogementId(Long logementId) {
		this.logementId = logementId;
	}



	public Date getArrival_date() {
		return arrival_date;
	}



	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}



	public Date getDeparture_date() {
		return departure_date;
	}



	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}



	public Long getNumber_of_people() {
		return number_of_people;
	}



	public void setNumber_of_people(Long number_of_people) {
		this.number_of_people = number_of_people;
	}



	


	
	

}
