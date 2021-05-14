package net.tuto.pfe.projet.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Etablissement")
public class Etablissement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="nometab")
	private String nom_etab;
	@Column(name="adresse")
	private String adresse;
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="etab")
	private Seance seance ;
	public Etablissement() {}
	public Etablissement(String nom_etab, String adresse) {
		super();
		this.nom_etab = nom_etab;
		this.adresse = adresse;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom_etab() {
		return nom_etab;
	}
	public void setNom_etab(String nom_etab) {
		this.nom_etab = nom_etab;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Seance getSeance() {
		return seance;
	}
	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	

}
