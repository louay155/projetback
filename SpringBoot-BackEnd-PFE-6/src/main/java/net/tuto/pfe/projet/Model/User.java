package net.tuto.pfe.projet.Model;

import java.util.Date;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
//@Entity
/*@Table(name="User")*/
public  abstract class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	//@Column(name="nom")
	private String nom;
	//@Column(name="prenom")
	private String prenom;
	//@Column(name="datenaiss")
	private Date date_naiss;
	//@Column(name="mdp")
	private String mdp;
	//@Column(name="login")
	private String login;
	//@Column(name="tel")
	private int tel;
	//@Column(name="email")
	private String email;
	/*@Enumerated(EnumType.STRING)
	@Column(name="Gender")*/
	private Gender gender;
	//@Column(name="ItemImage")
	private byte[] usrImage;
	private String adresse;
	public User() {}
	
	public User(String nom, String prenom, Date date_naiss, String mdp, String login, int tel, String email,
			Gender gender, byte[] usrImage, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_naiss = date_naiss;
		this.mdp = mdp;
		this.login = login;
		this.tel = tel;
		this.email = email;
		this.gender = gender;
		this.usrImage = usrImage;
		this.adresse = adresse;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_naiss() {
		return date_naiss;
	}
	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public byte[] getUsrImage() {
		return usrImage;
	}
	public void setUsrImage(byte[] usrImage) {
		this.usrImage = usrImage;
	}
	
	
	
	

}
