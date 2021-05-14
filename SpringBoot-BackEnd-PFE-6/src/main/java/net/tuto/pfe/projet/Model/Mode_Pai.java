package net.tuto.pfe.projet.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Mode_Paiement")
public class Mode_Pai {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	@Enumerated(EnumType.STRING)
	@Column(name="Mode")
	private Mode mode;
	public Mode_Pai() {}
	public Mode_Pai(Mode mode) {
		super();
		this.mode = mode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Mode getMode() {
		return mode;
	}
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	

}
