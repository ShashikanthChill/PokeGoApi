/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.services;

import com.the_humble_fool.PokeGoApi.models.servicemodels.ResearchBreakthroughEncountersServiceModel;
import com.the_humble_fool.PokeGoApi.jparepositories.ResearchBreakthroughEncountersJpaRepo;
import com.the_humble_fool.PokeGoApi.models.entitymodels.ResearchBreakthroughEncountersEntityModel;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author The_Humble_Fool
 */
@Service
public class ResearchBreakthroughEncountersPublicService
{

    @Autowired
    ResearchBreakthroughEncountersJpaRepo repo;

    public List<ResearchBreakthroughEncountersServiceModel> getAllResearchBreakthroughEncounters()
    {
        List<ResearchBreakthroughEncountersEntityModel> breakthroughEncountersEntityModels = repo.findAll();
        List<ResearchBreakthroughEncountersServiceModel> breakthroughEncountersServiceModels = breakthroughEncountersEntityModels.stream().map(ResearchBreakthroughEncountersPublicService::mapEntityToService).collect(Collectors.toList());

        return breakthroughEncountersServiceModels;
    }
    
    public List<ResearchBreakthroughEncountersServiceModel> getNamedResearchBreakthroughEncounters(String pokemon)
    {
        List<ResearchBreakthroughEncountersEntityModel> breakthroughEncountersEntityModels = repo.findByPokemonStartingWith(pokemon);
        List<ResearchBreakthroughEncountersServiceModel> breakthroughEncountersServiceModels = breakthroughEncountersEntityModels.stream().map(ResearchBreakthroughEncountersPublicService::mapEntityToService).collect(Collectors.toList());
        
        return breakthroughEncountersServiceModels;
    }

    private static  ResearchBreakthroughEncountersServiceModel mapEntityToService(ResearchBreakthroughEncountersEntityModel entityModel)
    {
        ResearchBreakthroughEncountersServiceModel serviceModel = new ResearchBreakthroughEncountersServiceModel();

        serviceModel.setPokeDex(entityModel.getPokeDex());
        serviceModel.setPokemon(entityModel.getPokemon());
        serviceModel.setMinCp(entityModel.getMinCp());
        serviceModel.setMaxCp(entityModel.getMaxCp());
        serviceModel.setShinyAvailable(entityModel.getShinyAvailable());

        return serviceModel;
    }
}
