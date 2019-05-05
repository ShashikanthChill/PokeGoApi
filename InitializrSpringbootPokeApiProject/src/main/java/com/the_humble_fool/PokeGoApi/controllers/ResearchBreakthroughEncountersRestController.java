/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.controllers;

import com.the_humble_fool.PokeGoApi.exceptions.ResearchBreakthroughEncounterNotFoundException;
import com.the_humble_fool.PokeGoApi.models.servicemodels.ResearchBreakthroughEncountersServiceModel;
import com.the_humble_fool.PokeGoApi.services.ResearchBreakthroughEncountersPublicService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author The_Humble_Fool
 */
@RestController
@RequestMapping(path = "public-api/breakthroughs")
public class ResearchBreakthroughEncountersRestController
{

    @Autowired
    ResearchBreakthroughEncountersPublicService service;

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ResearchBreakthroughEncountersServiceModel> AllEncoutersHandler()
    {
        return service.getAllResearchBreakthroughEncounters();
    }

    @RequestMapping(path = "filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ResearchBreakthroughEncountersServiceModel> AllFilteredEncountersHandler(@RequestParam("pokemon") String pokemon)
    {
        List<ResearchBreakthroughEncountersServiceModel> namedResearchBreakthroughEncounters = service.getNamedResearchBreakthroughEncounters(pokemon);
        
        if(namedResearchBreakthroughEncounters == null || namedResearchBreakthroughEncounters.isEmpty())
            throw new ResearchBreakthroughEncounterNotFoundException("Reseach breakthrough encounter(s) not found for 'pokemon'=`" + pokemon + "`");
        
        return namedResearchBreakthroughEncounters;
    }
}
