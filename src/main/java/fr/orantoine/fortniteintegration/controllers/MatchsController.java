package fr.orantoine.fortniteintegration.controllers;

import fr.orantoine.fortniteintegration.models.Match;
import fr.orantoine.fortniteintegration.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchsController {

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping(value = "/matchs")
    private List<Match> findAll(){
        return matchRepository.findAll();
    }

    @GetMapping(value = "/matchs/{id}")
    private List<Match> findByAccountId(@PathVariable String id){
        return matchRepository.findAllByAccountId(id);
    }

}
