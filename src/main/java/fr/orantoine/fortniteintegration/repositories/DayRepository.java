package fr.orantoine.fortniteintegration.repositories;

import fr.orantoine.fortniteintegration.models.Day;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DayRepository extends MongoRepository<Day,String> {

}
