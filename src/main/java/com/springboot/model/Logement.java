package com.springboot.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;



@Entity
@Table(name ="logement")
public class Logement {
	@Id @GeneratedValue
	private Long id;
	//@NotNull
	@Size(min=5,max=50)
	@NotEmpty
	private String intitule;
	@NotEmpty
	private String description;
	//@Size(min=20,max=10000)
	private double prix;
	@Size(min=5,max=100)
	private String adresse;
	//@Size(min=0)
	private int capacite;
	//@Value("${dir.images}")
	private String image;
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	
	
	public Logement(String intitule, String description, double prix, String adresse, int capacite, String image) {
		super();
		this.intitule = intitule;
		this.description = description;
		this.prix = prix;
		this.adresse = adresse;
		this.capacite = capacite;
		this.image = image;
	}
	public Logement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;  
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getImage() {
		return image;  
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	

}

