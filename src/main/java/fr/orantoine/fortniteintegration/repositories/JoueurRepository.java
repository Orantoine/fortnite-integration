package fr.orantoine.fortniteintegration.repositories;

import fr.orantoine.fortniteintegration.models.Joueur;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JoueurRepository extends MongoRepository<Joueur,String> {

    Joueur findByPseudo(String pseudo);
}
