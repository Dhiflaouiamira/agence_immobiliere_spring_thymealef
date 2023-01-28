package com.tekup.agence_Immobilier.entities;


import java.util.List;







import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;






@Entity
@Table(name = "T_User")
public class User  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
    
	@Column(name = "first_name")
    private String firstName;
	
	@Column(name = "last_name")
    private String lastName;
	
	@Column(nullable = false, unique = true, length = 45)
    private String email;
     
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "phone_number")
    private int phoneNumber ;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", cin=" + cin + ", activated="
				 + ", role=" + ", reservations=" + ", bienImmobiliers="
				 + ", reclamations=" + reclamations + "]";
	}

	@Column(name = "cin")
    private int cin;
	

//	@ManyToMany(cascade=CascadeType.MERGE)
	//@JoinTable(
	     // name="user_role",
	  //    joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
	  //    inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	
	
	@OneToMany(mappedBy= "user")
	private List<Reservation> reservations;

		
  
	
	@OneToMany(mappedBy= "user")
	private List<Reclamation> reclamations;

	public User() {
		super();
	}

	public User(long id, String firstName, String lastName, String email, String password, int phoneNumber,
			int cin) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.cin = cin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public Object getPrix() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPrix(Object prix) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	}

	



	
	
	

