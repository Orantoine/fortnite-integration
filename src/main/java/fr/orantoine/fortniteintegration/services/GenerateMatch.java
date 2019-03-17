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

import java.util.List;
import java.util.Optional;


@Service
public class GenerateMatch {

    @Autowired
    public MatchRepository matchRepository;

    private static final Logger log = LoggerFactory.getLogger(GenerateMatch.class);

    private JSONObject matchObject;


    public void generateField(JSONObject object){
        this.matchObject = object;
        Match match = new Match();
        match.setKills(matchObject.get("kills").toString());
        match.setId(matchObject.get("id").toString());
        match.setAccountId(matchObject.get("accountId").toString());
        match.setDateCollected(matchObject.get("dateCollected").toString());
        match.setMatches(matchObject.get("matches").toString());
        match.setPlatform(matchObject.get("platform").toString());
        match.setScore(matchObject.get("score").toString());
        match.setTop1(matchObject.get("top1").toString());
        match.setTop3(matchObject.get("top3").toString());
        match.setPlaylist(matchObject.get("playlist").toString());
        match.setMinutesPlayed(matchObject.get("minutesPlayed").toString());
        match.setTop5(matchObject.get("top5").toString());
        match.setTop6(matchObject.get("top6").toString());
        match.setTop12(matchObject.get("top12").toString());
        match.setTop10(matchObject.get("top10").toString());
        match.setTop25(matchObject.get("top25").toString());
        match.setTrnRating(matchObject.get("trnRating").toString());
        float ratio = 0;
        if(Integer.parseInt(matchObject.get("matches").toString()) != 0){
            float kills = Float.parseFloat(matchObject.get("kills").toString());
            float matches = Float.parseFloat(matchObject.get("matches").toString());
            ratio = kills/matches;
            match.setRatio(String.valueOf(ratio));
        }
        matchRepository.save(match);

    }
}