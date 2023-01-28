package com.tekup.agence_Immobilier.entities;
import java.util.List;





import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "T_Bien_Immobilier")
public class BienImmobilier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "nbPieces")
	private int nbPieces;
	
	@Column(name = "address")
	private String address;
	


	@Column(name = "Type")
	private String Type;
	
	
	@Column(name = "Contact")
	private String Contact;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "Images")
	 private byte[]  Images;
	 @ManyToOne
	 @JoinColumn(name = "user")
	 private User user;
	
	@OneToMany(mappedBy= "bienImmobilier")
	private List<Reservation> reservations;
	
	
	
	



	

	
	

	
	public String getDescription() {
		return description;
	}









	public void setDescription(String description) {
		this.description = description;
	}









	public BienImmobilier() {
		super();
	}

	

	
	
	



	public long getId() {
		return id;
	}





	public void setId(long id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public int getNbPieces() {
		return nbPieces;
	}





	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}










	public String getType() {
		return Type;
	}





	public void setType(String type) {
		Type = type;
	}





	public String getContact() {
		return Contact;
	}





	public void setContact(String contact) {
		Contact = contact;
	}





	public byte[] getImages() {
		return Images;
	}





	public void setImages(byte[] images) {
		Images = images;
	}





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}





	public List<Reservation> getReservations() {
		return reservations;
	}





	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}





	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", name=" + name + ", nbPieces=" + nbPieces + ", address=" + address
				+ ", price=" +  ", Type=" + Type + ", Contact=" + Contact + ", Images=" + Images + ", user=" + user
				+ ", reservations=" + reservations + "]";
	}









	public BienImmobilier(long id, String name, int nbPieces, String address, double price, String type, String contact,
			String description, byte[] images, User user, List<Reservation> reservations) {
		super();
		this.id = id;
		this.name = name;
		this.nbPieces = nbPieces;
		this.address = address;
		
		this.Type = type;
		this.Contact = contact;
		this.description = description;
		this.Images = images;
		this.user = user;
		this.reservations = reservations;
	}









	


	



}
