package fr.orantoine.fortniteintegration.services;

import fr.orantoine.fortniteintegration.models.Match;
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

    private static final Logger log = LoggerFactory.getLogger(GenerateMatch.class);

    private JSONObject matchObject;


    public void generateField(JSONObject object,String account){
        this.matchObject = object;
        Match match = new Match();
        match.setAccountName(account);
        match.setKills(matchObject.get("kills").toString());
        match.setId(matchObject.get("id").toString());
        match.setAccountId(matchObject.get("accountId").toString());
        match.setMatches(matchObject.get("matches").toString());
        match.setPlatform(matchObject.get("platform").toString());
        match.setScore(matchObject.get("score").toString());
        match.setTop1(matchObject.get("top1").toString());
        match.setTop3(matchObject.get("top3").toString());
        switch (matchObject.get("playlist").toString()){
            case "p2" : match.setPlaylist("solo");
                break;
            case  "p10": match.setPlaylist("duo");
                break;
            case "p9": match.setPlaylist("duo");
                break;
            default: match.setPlaylist("autre");
                break;
        }
        match.setMinutesPlayed(matchObject.get("minutesPlayed").toString());
        match.setTop5(matchObject.get("top5").toString());
        match.setTop6(matchObject.get("top6").toString());
        match.setTop12(matchObject.get("top12").toString());
        match.setTop10(matchObject.get("top10").toString());
        match.setTop25(matchObject.get("top25").toString());
        match.setTrnRating(matchObject.get("trnRating").toString());
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        Date fromCalendar = calendar.getTime();
        match.setDateCollected(fromCalendar);
        float ratio = 0;
        if(Integer.parseInt(matchObject.get("matches").toString()) != 0){
            float kills = Float.parseFloat(matchObject.get("kills").toString());
            float matches = Float.parseFloat(matchObject.get("matches").toString());
            ratio = kills/matches;
            match.setRatio(String.valueOf(ratio));
        }
        if("0".equals(match.getTop1())){
            log.info("Envoie d'un message sur le webhook discord");
            SendDiscord sendDiscord = new SendDiscord();
            sendDiscord.sendMessage("Felicitation à "+ match.getAccountName() + "pour son TOP1 avec :" + match.getKills());
            log.info("Message envoyé");
        }
        matchRepository.save(match);

    }
}
