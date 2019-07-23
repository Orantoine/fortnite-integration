package fr.orantoine.fortniteintegration.repositories;

import fr.orantoine.fortniteintegration.models.Day;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface DayRepository extends MongoRepository<Day,String> {

    List<Day> findAllByDayBetweenAndAccountNameEquals(Date start, Date end,String accountName);
    List<Day> findAllByAccountName(String account);


}
