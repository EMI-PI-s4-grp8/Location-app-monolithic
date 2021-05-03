package com.springboot.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name ="experience")
public class Experience {
	@Id 
	@GeneratedValue
	(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Avis is required")
	private String Avis;
	
	@NotNull(message = "Rating is required")
	@Size(min=0,max=5)
	private String rating;
	
	@NotNull
	private String idLogement;
	
	@NotNull
	private String idLocataire;
	
	public Experience(Long id, @NotNull(message = "Avis is required") String avis,
			@NotNull(message = "Rating is required") @Size(min = 0, max = 5) String rating, @NotNull String idLogement,
			@NotNull String idLocataire, @NotNull String nomLocataire) {
		super();
		this.id = id;
		Avis = avis;
		this.rating = rating;
		this.idLogement = idLogement;
		this.idLocataire = idLocataire;
		this.nomLocataire = nomLocataire;
	}


	@NotNull
	private String nomLocataire;
	
	



	//constructors

	public Experience() {
		super();
		
	}


	public Experience(@NotNull String nomLocataire,
			/* @NotNull(message = "Avis is required") */ String avis,
			/* @NotNull(message = "Rating is required") @Size(min = 0, max = 5) */String rating) {
		super();
		this.nomLocataire = nomLocataire;
		Avis = avis;
		this.rating = rating;
	}


	public Experience(
			/* @NotNull(message = "Avis is required") */String avis,
			/* @NotNull(message = "Rating is required") */ String rating) {
		super();
		Avis = avis;
		this.rating = rating;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIdLogement() {
		return idLogement;
	}


	public void setIdLogement(String idLogement) {
		this.idLogement = idLogement;
	}


	public String getNomLocataire() {
		return nomLocataire;
	}


	public void setNomLocataire(String nomLocataire) {
		this.nomLocataire = nomLocataire;
	}


	public String getAvis() {
		return Avis;
	}


	public void setAvis(String avis) {
		Avis = avis;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	

	
}
