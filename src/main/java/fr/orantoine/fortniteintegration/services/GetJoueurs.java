package fr.orantoine.fortniteintegration.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import fr.orantoine.fortniteintegration.models.Joueur;
import fr.orantoine.fortniteintegration.repositories.JoueurRepository;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetJoueurs {

    @Autowired
    private GenerateMatch generateMatch;

    @Autowired
    private JoueurRepository joueurRepository;

    private static final Logger log = LoggerFactory.getLogger(GetJoueurs.class);

    public void searchJoueurs() {
        List<Joueur> joueurs = joueurRepository.findAll();
        if(joueurs != null) {
            for (Joueur joueur : joueurs) {
                if (joueur.getPseudo() != null && joueur.getPlateforme() != null) {
                    for (String plateforme : joueur.getPlateforme()) {
                        if ("ps4".equals(plateforme) || "pc".equals(plateforme) || "xbox".equals(plateforme)) {
                            try {
                                HttpResponse<String> jsonResponse = Unirest.get("https://api.fortnitetracker.com/v1/profile/" + plateforme + "/" + joueur.getPseudo())
                                        .header("accept", "application/json")
                                        .header("TRN-Api-Key", "2dda56fe-8332-49f0-a4b5-7266757efdf4")
                                        .header("cache-control", "no-cache").asString();
                                getInfo(jsonResponse.getBody(), joueur.getPseudo());
                                log.info("Recherche du joueur " + joueur.getPseudo() + " sur la plateforme " + plateforme);
                            } catch (UnirestException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public void getInfo(String jsonResponse,String pseudo){
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray recentMatch = new JSONArray();
        recentMatch = jsonObject.getJSONArray("recentMatches");
        generateMatch.generateField(recentMatch.getJSONObject(0),pseudo);
    }

}
