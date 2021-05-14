package net.tuto.pfe.projet.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.tuto.pfe.projet.Exception.RessourceNotFoundException;
import net.tuto.pfe.projet.Model.Matiere;
import net.tuto.pfe.projet.Repository.MatiereRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class MatiereController {
	@Autowired
	private MatiereRepository matiereRepository ;
	/*@Autowired
	private EleveRepository eleverepository ;
	@Autowired
	private ProfesseurRepository profrepository ;*/
	//getAllMatiere
	@GetMapping("/matieres")
	public List<Matiere> getAllmatieres()
	{
		
		return matiereRepository.findAll();
	}
	//getAllMatiere
	@GetMapping("/matiere")
/*	public List<Matiere> getmatiere()
	{
		return matiereRepository ;
	}*/
	//create matiere
	@PostMapping("/matieres")
	public Matiere creatematiere(@RequestBody Matiere matiere)
	{
		
		return matiereRepository.save(matiere);
	}
	//getmatiereById
	@GetMapping("/matieres/{id}")
	public ResponseEntity<Matiere> getMatById(@PathVariable long id)
	{
		Matiere matiere=matiereRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("matiere does not exist with this id:"+id));
		return ResponseEntity.ok(matiere);
	}
	//updateMatiere
	@PutMapping("matieres/{id}")
	public ResponseEntity<Matiere> UpdateMatiere(@PathVariable long id , @RequestBody Matiere matieredetails)
	{
		Matiere matiere=matiereRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("matiere does not exist with this id:"+id));
		matiere.setLibelle(matieredetails.getLibelle());
		matiere.setNiveau(matieredetails.getNiveau());
		matiere.setSeance(matieredetails.getSeance());
		Matiere UpdateMatiere=matiereRepository.save(matiere);
		return ResponseEntity.ok(UpdateMatiere);
		
	}
	//DeleteMatiere
	@DeleteMapping("matieres/{id}")
	ResponseEntity<Map<String,Boolean>> deletmatiere(@PathVariable long id)
	{
		Matiere matiere=matiereRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("matiere does not exist with this id:"+id));
		matiereRepository.delete(matiere);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}

	/*@PutMapping("/{id_mat}/eleve/{id_eleve}")
	Matiere affecterelevetoMatiere(
			@PathVariable long id_mat,
			@PathVariable long id_eleve
			) {
				Matiere matiere = matiereRepository.findById(id_mat).get();
				Eleve eleve = eleverepository.findById(id_eleve).get();
						matiere.leleve(eleve);
						return matiereRepository.save(matiere);
	}
	
	@PutMapping("{id_mat}/professeurs/{id_prof}")
	Matiere affecterProfesseurToMatiere(
			@PathVariable long id_mat,
			@PathVariable long id_prof
			) {
		Matiere matiere = matiereRepository.findById(id_mat).get();
		Professeur professeur = profrepository.findById(id_prof).get();
		Matiere.professeur(professeur);
		return matiereRepository.save(matiere);
		
		
	}
	
}*/
	
}