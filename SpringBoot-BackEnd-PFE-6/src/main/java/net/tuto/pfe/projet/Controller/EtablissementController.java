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
import net.tuto.pfe.projet.Model.Etablissement;
import net.tuto.pfe.projet.Repository.EtablissementRespository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class EtablissementController {
	@Autowired
	private EtablissementRespository etablissementrepository ;
	//getLesEtablissements
	@GetMapping("/etablissements")
	public List<Etablissement> getAllEtabli(){
		return etablissementrepository.findAll();
	}
	//createEtablissements
	@PostMapping("/etablissements")
	public Etablissement createEtabl( @RequestBody Etablissement etablissement)
	{
		return etablissementrepository.save(etablissement);
	}
	//getEtablissementById
	@GetMapping("/etablissements/{id}")
	public ResponseEntity<Etablissement> getEtaById (@PathVariable long id)
	{
		Etablissement etablissement=etablissementrepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("etablissement does not exist with this id:"+id));
		return ResponseEntity.ok(etablissement);
	
	}
	//updateEtablissement
	@PutMapping("/etablissements/{id}")
	public ResponseEntity<Etablissement> updateetablissement(@PathVariable long id, @RequestBody Etablissement etablissementdetails)
	{
		Etablissement etablissement=etablissementrepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("etablissement does not exist with this id:"+id));
		etablissement.setNom_etab(etablissementdetails.getNom_etab());
		etablissement.setAdresse(etablissementdetails.getAdresse());
		
		Etablissement updateetablissement=etablissementrepository.save(etablissement);
		return ResponseEntity.ok(updateetablissement);
	}
	//deleteEtablissement
	@DeleteMapping("/etablissements/{id}")
	ResponseEntity<Map<String,Boolean>>  deleteEta(@PathVariable long id)
	{

		Etablissement etablissement=etablissementrepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("etablissement does not exist with this id:"+id));
		etablissementrepository.delete(etablissement);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}
	

}
