package fr.orantoine.fortniteintegration.services;

import fr.orantoine.fortniteintegration.models.Match;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenerateMatch {

    private static final Logger log = LoggerFactory.getLogger(GenerateMatch.class);

    private JSONObject matchObject;

    public GenerateMatch(JSONObject object){
        this.matchObject = object;
    }

    public void generateField(){
        Match match = new Match();
        match.setKills(matchObject.get("kills").toString());
        match.setId(matchObject.get("id").toString());
        match.setAccountId(matchObject.get("accountId").toString());
        match.setDateCollected(matchObject.get("dateCollected").toString());
        match.setMatches(matchObject.get("matches").toString());
        match.setPlatform(matchObject.get("platform").toString());
        match.setScore(matchObject.get("score").toString());
    }
}
