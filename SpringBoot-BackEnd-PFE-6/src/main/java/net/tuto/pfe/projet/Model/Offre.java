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
@Table(name="Offre")
public class Offre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nom_offre")
	private String nom_off;
	
	@Column(name="prix")
	private int prix;
	
	
	//mapping paiement & offre
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="offre")
	private Paiement paiement ;
	
	
	
	public Offre() {}
	public Offre(String nom_off, int prix) {
		super();
		this.nom_off = nom_off;
		this.prix = prix;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom_off() {
		return nom_off;
	}
	public void setNom_off(String nom_off) {
		this.nom_off = nom_off;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public Paiement getPaiement() {
		return paiement;
	}
	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
	
	
	


	
}
