package fr.orantoine.fortniteintegration.task;

import fr.orantoine.fortniteintegration.models.Joueur;
import fr.orantoine.fortniteintegration.repositories.JoueurRepository;
import fr.orantoine.fortniteintegration.services.GenerateDay;
import fr.orantoine.fortniteintegration.services.GetJoueurs;
import fr.orantoine.fortniteintegration.services.GetMatchs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InfoJoueurs {

    public Date startDay;

    @Autowired
    private GetJoueurs getJoueurs;

    @Autowired
    private GetMatchs getMatchs;

    @Autowired
    private JoueurRepository joueurRepository;

    @Autowired
    private GenerateDay generateDay;

    private static final Logger log = LoggerFactory.getLogger(InfoJoueurs.class);

    @Scheduled(cron = "0 0/1 * * * *",zone = "GMT+1:00")
    public void getData(){
        getJoueurs.searchJoueurs();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        Date fromCalendar = calendar.getTime();
        log.info("Récupération des données terminé " +  fromCalendar);
    }

    @Scheduled(cron = "00 59 23 * * *",zone = "GMT+1:00")
    public void getEndDay(){
        List<Joueur> joueurs = joueurRepository.findAll();
        if(joueurs != null){
            for (Joueur joueur:joueurs) {
                generateDay.generate(joueur);
            }
        }
    }

}
