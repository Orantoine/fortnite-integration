package fr.orantoine.fortniteintegration.services;

import fr.orantoine.fortniteintegration.models.Day;
import fr.orantoine.fortniteintegration.models.Match;
import fr.orantoine.fortniteintegration.repositories.DayRepository;
import fr.orantoine.fortniteintegration.repositories.MatchRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class GenerateMatch {

    @Autowired
    public MatchRepository matchRepository;

    @Autowired
    public DayRepository dayRepository;

    private static final Logger log = LoggerFactory.getLogger(GenerateMatch.class);



    private String alerting = System.getenv("Alerting");

    private JSONObject matchObject;


    public void generateFieldDay(JSONObject object,String account){
        this.matchObject = object;
        Date[] dates = intervalleconvertNowToDate();
        List<Day> day = dayRepository.findAllByDayBetweenAndAccountNameEquals(dates[0],dates[1],account);
        if (day == null || day.size()==0)
            createnewDay(object,account);
        else{
            addMatchToDay(day,object,account);
        }

    }

    private void addMatchToDay(List<Day> day, JSONObject object, String account) {

        Day day1 = day.get(0);
        boolean matchpresent = false;
        for (Match match :day1.getListMatchs()) {
            if(matchObject.get("id").toString().equals(match.getId())) matchpresent = true;
        }
        if(!matchpresent){
            Match match = new Match();
            match.setKills(matchObject.get("kills").toString());
            match.setId(matchObject.get("id").toString());
            match.setMatches(matchObject.get("matches").toString());
            match.setTop1(matchObject.get("top1").toString());
            match.setTop3(matchObject.get("top3").toString());
            switch (matchObject.get("playlist").toString()) {
                case "p2":
                    match.setPlaylist("solo");
                    break;
                case "p10":
                    match.setPlaylist("duo");
                    break;
                case "p9":
                    match.setPlaylist("sqquad");
                    break;
                default:
                    match.setPlaylist("autre");
                    break;
            }
            match.setMinutesPlayed(matchObject.get("minutesPlayed").toString());
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
            if (Integer.parseInt(matchObject.get("matches").toString()) != 0) {
                float ratio = 0;
                float kills = Float.parseFloat(matchObject.get("kills").toString());
                float matches = Float.parseFloat(matchObject.get("matches").toString());
                ratio = kills / matches;
                match.setRatio(String.valueOf(ratio));
            }
            ArrayList<Match> lstMatchs = new ArrayList<>();
            float ratio = 0;
            float matches = 0 ;
            float kills = 0;
            for (Match matchs : day1.getListMatchs()) {
                if (Integer.parseInt(matchs.getMatches()) != 0) {
                    kills += Float.parseFloat(matchs.getKills());
                    matches += Float.parseFloat(matchs.getMatches());
                    match.setRatio(String.valueOf(ratio));
                }
                lstMatchs.add(matchs);
            }
            kills += Float.parseFloat(match.getKills());
            matches += Float.parseFloat(match.getMatches());
            ratio = kills/matches;
            day1.setMatchs(matches);
            day1.setKills(kills);
            day1.setRatio(ratio);
            lstMatchs.add(match);
            day1.setListMatchs(lstMatchs.toArray(new Match[lstMatchs.size()]));
            dayRepository.save(day1);
        }

    }

    private void createnewDay(JSONObject object, String account) {
        Day day = new Day();
        Match match = new Match();
        match.setKills(matchObject.get("kills").toString());
        match.setId(matchObject.get("id").toString());
        match.setMatches(matchObject.get("matches").toString());
        match.setTop1(matchObject.get("top1").toString());
        match.setTop3(matchObject.get("top3").toString());
        switch (matchObject.get("playlist").toString()) {
            case "p2":
                match.setPlaylist("solo");
                break;
            case "p10":
                match.setPlaylist("duo");
                break;
            case "p9":
                match.setPlaylist("suquad");
                break;
            default:
                match.setPlaylist("autre");
                break;
        }
        match.setMinutesPlayed(matchObject.get("minutesPlayed").toString());
        float ratio = 0;
        if (Integer.parseInt(matchObject.get("matches").toString()) != 0) {
            float kills = Float.parseFloat(matchObject.get("kills").toString());
            float matches = Float.parseFloat(matchObject.get("matches").toString());
            ratio = kills / matches;
            match.setRatio(String.valueOf(ratio));
        }
        day.setAccountName(account);
        day.setAccountid(matchObject.get("accountId").toString());
        day.setKills(Integer.parseInt(match.getKills()));
        day.setRatio(Integer.parseInt(match.getRatio()));
        day.setMatchs(Integer.parseInt(matchObject.get("matches").toString()));
        Match[] listmatch = {match};
        day.setListMatchs(listmatch);
        day.setWins(Integer.parseInt(match.getTop1()));
        day.setDay(new Date());
        dayRepository.save(day);
    }

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


}
