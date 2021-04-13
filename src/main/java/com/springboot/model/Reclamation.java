package com.springboot.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name ="reclamation")
public class Reclamation {
	@Id @GeneratedValue
	private Long id;
	//@NotNull
	@Email
	private String email;
	@NotEmpty
	@Size(min=5,max=50)
	private String objet;
	@NotEmpty
	@Size(min=0,max=150)
	private String message;
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reclamation(@Email String email, @NotEmpty @Size(min = 5, max = 50) String objet,
			@Size(min = 0, max = 150) String message) {
		super();
		this.email = email;
		this.objet = objet;
		this.message = message;
	}
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
