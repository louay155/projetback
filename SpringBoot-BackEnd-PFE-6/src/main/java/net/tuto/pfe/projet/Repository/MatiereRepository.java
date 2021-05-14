package net.tuto.pfe.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.tuto.pfe.projet.Model.Matiere;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere,Long>  {

	
}
