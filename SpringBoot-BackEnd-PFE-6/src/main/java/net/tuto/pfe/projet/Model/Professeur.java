package net.tuto.pfe.projet.Model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;


@Entity
public class Professeur extends User {

	private String diplome;
	private String Specialite;
	private  String niv_etude;
	//mapping seance & prof
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="prof")
	private Seance seance ;
	public Professeur() {}
	
	

	public Professeur(String nom, String prenom, Date date_naiss, String mdp, String login, int tel, String email,
			Gender gender, byte[] usrImage, String adresse) {
		super(nom, prenom, date_naiss, mdp, login, tel, email, gender, usrImage, adresse);
		// TODO Auto-generated constructor stub
	}



	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getSpecialite() {
		return Specialite;
	}
	public void setSpecialite(String specialite) {
		Specialite = specialite;
	}
	public String getNiv_etude() {
		return niv_etude;
	}
	public void setNiv_etude(String niv_etude) {
		this.niv_etude = niv_etude;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	
	
}
