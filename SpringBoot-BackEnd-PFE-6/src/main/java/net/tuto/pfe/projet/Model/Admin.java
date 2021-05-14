package net.tuto.pfe.projet.Model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Admin  extends User {
public Admin() {}

public Admin(String nom, String prenom, Date date_naiss, String mdp, String login, int tel, String email, Gender gender,
		byte[] usrImage, String adresse) {
	super(nom, prenom, date_naiss, mdp, login, tel, email, gender, usrImage, adresse);
	// TODO Auto-generated constructor stub
}


	
}
