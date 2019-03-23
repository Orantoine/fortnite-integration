package fr.orantoine.fortniteintegration.task;

import fr.orantoine.fortniteintegration.services.GetJoueurs;
import fr.orantoine.fortniteintegration.services.GetMatchs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class InfoJoueurs {

    public Date startDay;

    @Autowired
    private GetJoueurs getJoueurs;

    @Autowired
    private GetMatchs getMatchs;

    private static final Logger log = LoggerFactory.getLogger(InfoJoueurs.class);

    private String listJoueurs = System.getenv("LIST_JOUEURS");

    @Scheduled(cron = "0 0/1 * * * *")
    public void getData(){
        getJoueurs.searchJoueurs();
        log.info("Récupération des données terminé "+ new Date());
    }

    @Scheduled(cron = "0 0 1 * * *")
    public void getStartDay(){
        log.info("Récupération du début de journée");
        startDay = new Date();
        log.info("La date du début de journée est : "+startDay);
    }

    @Scheduled(cron = "59 59 23 * * *")
    public void getEndDay(){
        log.info("Récupération du fin de journée");
        Date endDay = new Date();
        log.info("La date du début de journée est : "+endDay);
        String[] joueurs = getJoueurs.returnJoueurs(listJoueurs);
        for (String joueur:joueurs) {
            String idJoueur = getJoueurs.returnID(joueur);
            getMatchs.getMathByDay(idJoueur,startDay,endDay);
        }

    }

}
