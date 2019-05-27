package fr.orantoine.fortniteintegration.controllers;


import fr.orantoine.fortniteintegration.task.InfoJoueurs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {



    @GetMapping(value = "/integration/health")
    public String HealthCheck(){
        return "OK";
    }
}
