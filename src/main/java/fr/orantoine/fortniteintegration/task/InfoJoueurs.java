package fr.orantoine.fortniteintegration.task;

import fr.orantoine.fortniteintegration.services.GetJoueurs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class InfoJoueurs {

    @Autowired
    private GetJoueurs getJoueurs;

    private static final Logger log = LoggerFactory.getLogger(InfoJoueurs.class);

    @Scheduled(cron = "0/20 * * * * *")
    public void testCron(){
        log.info("Recherche des statistiques des joueurs intialisés");
        getJoueurs.searchJoueurs();
        log.info("Recherche terminée avec succès");
    }
}
