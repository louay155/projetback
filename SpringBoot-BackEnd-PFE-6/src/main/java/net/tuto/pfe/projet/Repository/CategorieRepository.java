package net.tuto.pfe.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.tuto.pfe.projet.Model.Categorie;

@Repository
public interface CategorieRepository  extends JpaRepository<Categorie,Long>{

}
