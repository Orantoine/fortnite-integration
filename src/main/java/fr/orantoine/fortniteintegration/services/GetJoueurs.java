package fr.orantoine.fortniteintegration.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GetJoueurs {

    @Autowired
    private GenerateMatch generateMatch;

    private static final Logger log = LoggerFactory.getLogger(GetJoueurs.class);

    private String listJoueurs = System.getenv("LIST_JOUEURS");


    public String[] returnJoueurs(String listJoueurs){
        String[] listJoueur = listJoueurs.split(";");
        return listJoueur;
    }

    public void searchJoueurs() {
        if(listJoueurs != null) {
            String[] listJoueur = returnJoueurs(listJoueurs);
            for (String joueur:listJoueur) {
                try {
                    HttpResponse<String> jsonResponse = Unirest.get("https://api.fortnitetracker.com/v1/profile/ps4/"+joueur)
                            .header("accept", "application/json")
                            .header("TRN-Api-Key", "2dda56fe-8332-49f0-a4b5-7266757efdf4")
                            .header("cache-control", "no-cache").asString();
                    getInfo(jsonResponse.getBody());
                    log.info("Recherche pour le compte de : "+joueur);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void getInfo(String jsonResponse){
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray recentMatch = new JSONArray();
        recentMatch = jsonObject.getJSONArray("recentMatches");
        generateMatch.generateField(recentMatch.getJSONObject(0));
    }
}
