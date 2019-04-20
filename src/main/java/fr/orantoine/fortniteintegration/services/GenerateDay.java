package fr.orantoine.fortniteintegration.services;

import fr.orantoine.fortniteintegration.models.Day;
import fr.orantoine.fortniteintegration.models.Joueur;
import fr.orantoine.fortniteintegration.models.Match;
import fr.orantoine.fortniteintegration.repositories.DayRepository;
import fr.orantoine.fortniteintegration.repositories.MatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class GenerateDay {

    private static final Logger log = LoggerFactory.getLogger(GenerateDay.class);

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private DayRepository dayRepository;

    public Date[] intervalleconvertNowToDate(){
        Calendar calendarMatin = Calendar.getInstance();
        calendarMatin.set(Calendar.HOUR_OF_DAY,0);
        calendarMatin.set(Calendar.MINUTE,0);
        calendarMatin.set(Calendar.SECOND,0);
        Date matin = calendarMatin.getTime();
        Calendar calendarSoir = Calendar.getInstance();
        calendarSoir.set(Calendar.HOUR_OF_DAY,23);
        calendarSoir.set(Calendar.MINUTE,59);
        calendarSoir.set(Calendar.SECOND,0);
        Date soir = calendarSoir.getTime();
        Date[] intervalle = {matin,soir};
        return intervalle;
    }


    public void generate(Joueur joueur){
        Date[] dates = intervalleconvertNowToDate();
        List<Match> listMatchs = matchRepository.findAllByAccountIdAndDateCollectedIsBetween(joueur.getAccountid(), dates[0], dates[1]);
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
        for (Match match : listMatchs) {
            matchs += Integer.parseInt(match.getMatches());
            kills += Integer.parseInt(match.getKills());
            score += Integer.parseInt(match.getScore());
            wins += Integer.parseInt(match.getTop1());
            accountId = match.getAccountId();
            switch (match.getPlaylist()){
                case "solo" : solo++;
                    break;
                case "duo": duo++;
                    break;
                case "squad": section++;
                    break;
                default:
                    break;
            }
        }
        Day day = new Day();
        day.setAccountid(accountId);
        day.setDay(date);
        day.setKills(kills);
        day.setMatchs(matchs);
        day.setDuo(duo);
        day.setSolo(solo);
        day.setSection(section);
        day.setAccountName(joueur.getPseudo());
        if(matchs > 0)
            day.setRatio(Float.parseFloat(""+kills)/Float.parseFloat(matchs+""));
        else
            day.setRatio(0);
        day.setWins(wins);
        Day saveDay = dayRepository.save(day);
        log.info("Nouvelle journée enregistrée avec succès. Son Id est le : "+saveDay.getId());
    }

}
