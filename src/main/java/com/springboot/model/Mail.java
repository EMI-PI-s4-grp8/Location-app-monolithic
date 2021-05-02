package com.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class Mail {
	@Id @GeneratedValue
	private long id;
	@Email
	private String email;
	private String objet;
	@Size(min=10,max=150)
	private String text;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Mail(String email) {
		super();
		this.email = email;
		
	}
	public Mail(String email,String obje) {
		super();
		this.email = email;
		this.objet= "Réponse de votre reclamation:"+ obje;
		
	}
	public Mail(String email, String objet, String text) {
		super();
		this.email = email;
		this.objet = objet;
		this.text = text;
	}
	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}
}