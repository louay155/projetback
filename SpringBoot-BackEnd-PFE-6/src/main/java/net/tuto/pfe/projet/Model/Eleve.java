package net.tuto.pfe.projet.Model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Eleve  extends User {
	private String Nom_Prere;
	private String Nom_Mere;
	private String cin_par;
	private int tel_mere;
	private int tel_pere;
	private int etab_scolaire;
	//mapping seance & eleve
		@ManyToOne
		private Seance seance ;
		//mapping paiement eleve
		@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="eleve")
		private Paiement paiement ;
	public Eleve() {}
	
	

	public Eleve(String nom, String prenom, Date date_naiss, String mdp, String login, int tel, String email,
			Gender gender, byte[] usrImage, String adresse) {
		super(nom, prenom, date_naiss, mdp, login, tel, email, gender, usrImage, adresse);
		// TODO Auto-generated constructor stub
	}



	public String getNom_Prere() {
		return Nom_Prere;
	}
	public void setNom_Prere(String nom_Prere) {
		Nom_Prere = nom_Prere;
	}
	public String getNom_Mere() {
		return Nom_Mere;
	}
	public void setNom_Mere(String nom_Mere) {
		Nom_Mere = nom_Mere;
	}
	public String getCin_par() {
		return cin_par;
	}
	public void setCin_par(String cin_par) {
		this.cin_par = cin_par;
	}
	public int getTel_mere() {
		return tel_mere;
	}
	public void setTel_mere(int tel_mere) {
		this.tel_mere = tel_mere;
	}
	public int getTel_pere() {
		return tel_pere;
	}
	public void setTel_pere(int tel_pere) {
		this.tel_pere = tel_pere;
	}
	public int getEtab_scolaire() {
		return etab_scolaire;
	}
	public void setEtab_scolaire(int etab_scolaire) {
		this.etab_scolaire = etab_scolaire;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
	
	

}
