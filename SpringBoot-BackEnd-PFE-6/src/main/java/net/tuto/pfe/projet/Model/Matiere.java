package net.tuto.pfe.projet.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name="matiere")
public class Matiere {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
				//mapping seance & matiere
			
				@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="matiere")
				private Seance seance ;
				@Column(name="libelle")
				private String libelle;
				//mapping Matiere & niveau
				//@JsonIgnore
				@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
				@JoinTable(name="matiere_niveau",
				joinColumns= @JoinColumn(name="id_mat"),
				
						inverseJoinColumns = @JoinColumn(name="id_niv")
				)
				private List<Niveau> niveau;

	public Matiere() {}
	public Matiere(String libelle) {
		super();
		this.libelle = libelle;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Seance getSeance() {
		return seance;
	}
	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	public List<Niveau> getNiveau() {
		return niveau;
	}
	public void setNiveau(List<Niveau> niveau) {
		this.niveau = niveau;
	}
	

}
