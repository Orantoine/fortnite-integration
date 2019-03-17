package fr.orantoine.fortniteintegration.repositories;

import fr.orantoine.fortniteintegration.models.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends MongoRepository<Match,String> {

}
