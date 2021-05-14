package net.tuto.pfe.projet.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="seance")
public class Seance{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	@Column(name="date_seance")
	private Date date_sce;
	@Column(name="heure_debut")
	private Date heure_deb;
	@Column(name="heure_fin")
	private Date heure_fin;
	@Column(name="salle")
	private String Salle;
	//mapping eleve & prof
	@OneToMany
	private List<Eleve>leleve;
	//mapping prof & seance 
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="id_prof")
	private Professeur prof;
	//mapping matiere & seance 
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="id_mat")
	private Matiere matiere;
	//mapping AS & seance 
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="Annee_Scolaire")
	private AnneeScolaire annescolaire;
	//mapping etab & seance 
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="id_etab")
	private Etablissement etab;
	
	public Seance() {}
	public Seance(Date date_sce, Date heure_deb, Date heure_fin, String salle) {
		super();
		this.date_sce = date_sce;
		this.heure_deb = heure_deb;
		this.heure_fin = heure_fin;
		Salle = salle;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate_sce() {
		return date_sce;
	}
	public void setDate_sce(Date date_sce) {
		this.date_sce = date_sce;
	}
	public Date getHeure_deb() {
		return heure_deb;
	}
	public void setHeure_deb(Date heure_deb) {
		this.heure_deb = heure_deb;
	}
	public Date getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(Date heure_fin) {
		this.heure_fin = heure_fin;
	}
	public String getSalle() {
		return Salle;
	}
	public void setSalle(String salle) {
		Salle = salle;
	}
	public Professeur getProf() {
		return prof;
	}
	public void setProf(Professeur prof) {
		this.prof = prof;
	}
	public List<Eleve> getLeleve() {
		return leleve;
	}
	public void setLeleve(List<Eleve> leleve) {
		this.leleve = leleve;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public AnneeScolaire getAnnescolaire() {
		return annescolaire;
	}
	public void setAnnescolaire(AnneeScolaire annescolaire) {
		this.annescolaire = annescolaire;
	}
	public Etablissement getEtab() {
		return etab;
	}
	public void setEtab(Etablissement etab) {
		this.etab = etab;
	}
	

}
