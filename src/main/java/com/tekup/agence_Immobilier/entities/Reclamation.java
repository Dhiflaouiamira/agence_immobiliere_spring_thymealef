package com.tekup.agence_Immobilier.entities;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "T_Reclamation")
public class Reclamation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "TypeR")
	private String TypeR;
	
	
	public Reclamation(long id, String description, String typeR, String date, User user) {
		super();
		this.id = id;
		this.description = description;
		TypeR = typeR;
		this.date = date;
		this.user = user;
	}


	public String getTypeR() {
		return TypeR;
	}


	public void setTypeR(String typeR) {
		TypeR = typeR;
	}


	@Column(name = "date")
	private String date;
	
	
	public Reclamation(long id, String description , String date, User user) {
		super();
		this.id = id;
		this.description = description;
		
		this.date = date;
		this.user = user;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn( name = "id_user")
	
	private User user;
	



	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reclamation(long id, String description, String Type) {
		super();
		this.id = id;
		this.description = description;
	
	}


	public Reclamation(long id, String description,  User user) {
		super();
		this.id = id;
		this.description = description;
		
		this.user = user;
	}

	
	
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	

	

	

	
	
	
}

