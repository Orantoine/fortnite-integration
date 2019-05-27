package fr.orantoine.fortniteintegration.controllers;


import fr.orantoine.fortniteintegration.models.Joueur;
import fr.orantoine.fortniteintegration.repositories.JoueurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JoueursController {

    @Autowired
    private JoueurRepository joueurRepository;
    private static final Logger log = LoggerFactory.getLogger(JoueursController.class);


    @GetMapping(value = "/joueurs")
    public List<Joueur> findAll(){
        return joueurRepository.findAll();
    }

    @PostMapping(value = "/joueurs")
    public Joueur addJoueur(@RequestBody Joueur joueur){
        log.debug("Voici le contenu du joueur" +joueur);
        return joueurRepository.save(joueur);
    }
}
