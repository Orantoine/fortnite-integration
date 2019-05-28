package fr.orantoine.fortniteintegration.services;

import fr.orantoine.fortniteintegration.models.Day;
import fr.orantoine.fortniteintegration.models.Match;
import fr.orantoine.fortniteintegration.repositories.DayRepository;
import fr.orantoine.fortniteintegration.repositories.MatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class GetMatchs {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private DayRepository dayRepository;

    private static final Logger log = LoggerFactory.getLogger(GetMatchs.class);

    public void generateDay(List<Match> listMatch){
        log.info("Generation du bilan du match");
        int matchs = 0;
        int kills = 0;
        int score = 0;
        int duo = 0;
        int section = 0;
        int solo = 0;
        int wins = 0;
        String accountId = null;
        Date date = new Date();
        for (Match match : listMatch) {
                matchs += Integer.parseInt(match.getMatches());
                kills += Integer.parseInt(match.getKills());
                wins += Integer.parseInt(match.getTop1());
        }
        Day day = new Day();
        day.setAccountid(accountId);
        day.setDay(date);
        day.setKills(kills);
        day.setMatchs(matchs);
        if(matchs > 0)
            day.setRatio(Float.parseFloat(""+kills)/Float.parseFloat(matchs+""));
        else
            day.setRatio(0);
        day.setWins(wins);
        Day saveDay = dayRepository.save(day);
        log.info("Nouvelle journée enregistrée avec succès. Son Id est le : "+saveDay.getId());
    }
}
