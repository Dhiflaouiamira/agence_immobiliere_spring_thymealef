package com.tekup.agence_Immobilier.entities;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "T_Reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "montant")
	private double montant;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_debut")
  private Date  dateDebut;
	
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_fin")
	private Date dateFin;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn( name = "id_userr")

	private User user;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn( name = "id_bien_immobilier")
	
	private BienImmobilier bienImmobilier;



	public Reservation(int id, double montant, Date dateDebut, Date dateFin, User user,BienImmobilier bienImmobilier) {
		super();
			                                               
		this.id = id;
		this.montant = montant;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.user = user;
		this.bienImmobilier = bienImmobilier;
	}
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BienImmobilier getBienImmobilier() {
		return bienImmobilier;
	}

	public void setBienImmobilier(BienImmobilier bienImmobilier) {
		this.bienImmobilier = bienImmobilier;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", montant=" + montant + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ "]";
	}
	
}
