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
import net.tuto.pfe.projet.Model.Professeur;
import net.tuto.pfe.projet.Repository.ProfesseurRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ProfesseurController {

	@Autowired
	private ProfesseurRepository professeurRepository ;
	//get All Professeurs
	@GetMapping("/professeurs")
	public List<Professeur> getAllProfesseurs(){
		return professeurRepository.findAll();
	}
	//creat Professeur 
	@PostMapping("/professeurs")
	public Professeur createProfesseurs(@RequestBody Professeur professeur) {
		return professeurRepository.save(professeur);
	}
	//get professeur by Id
	@GetMapping("/professeurs/{id}")
	public ResponseEntity<Professeur> getProfesseurById(@PathVariable long id)
	{
		Professeur professeur = professeurRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("professeur not exist with:"+id));
		return ResponseEntity.ok(professeur);
	}
	//update Professeur 
	@PutMapping("/professeurs/{id}")
	public ResponseEntity<Professeur> Updateprofesseur( @PathVariable long id, @RequestBody Professeur professeurDetails){
		
		Professeur professeur = professeurRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("professeur not exist with:"+id));
		professeur.setNom(professeurDetails.getNom());
		professeur.setPrenom(professeurDetails.getPrenom());
		professeur.setAdresse(professeurDetails.getAdresse());
		professeur.setEmail(professeurDetails.getEmail());
		professeur.setDate_naiss(professeurDetails.getDate_naiss());
	
		professeur.setDiplome(professeurDetails.getDiplome());
		
		
		Professeur Updateprofesseur = professeurRepository.save(professeur);
				return ResponseEntity.ok(Updateprofesseur);
		
		
	}
	// delete professeur rest api
	@DeleteMapping("/professeurs/{id}")
	public ResponseEntity<Map<String,Boolean>> Deleteprofesseur( @PathVariable long id){
	Professeur professeur = professeurRepository.findById(id)
	.orElseThrow(()-> new RessourceNotFoundException("professeur not exist with:"+id));
	
	
	professeurRepository.delete(professeur);
	Map<String,Boolean> response = new HashMap<>();
	response.put("deleted",Boolean.TRUE);
	return ResponseEntity.ok(response); 	
	
	
	}
}
