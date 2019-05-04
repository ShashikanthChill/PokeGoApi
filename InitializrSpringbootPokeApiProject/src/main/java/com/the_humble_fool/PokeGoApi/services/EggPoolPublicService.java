/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.services;

import com.the_humble_fool.PokeGoApi.jparepositories.EggPoolJpaRepo;
import com.the_humble_fool.PokeGoApi.models.entitymodels.EggPoolEntityModel;
import com.the_humble_fool.PokeGoApi.models.servicemodels.EggPoolServiceModel;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author The_Humble_Fool
 */
@Service
public class EggPoolPublicService
{

    @Autowired
    EggPoolJpaRepo repo;

    public List<EggPoolServiceModel> getAllEggpools()
    {
        List<EggPoolEntityModel> eggPoolEntityModels = repo.findAll();
        List<EggPoolServiceModel> eggPoolServiceModels = eggPoolEntityModels.stream().map(EggPoolPublicService::mapEntityToService).collect(Collectors.toList());
        
        return eggPoolServiceModels;
    }
    
    public List<EggPoolServiceModel> getDistancedEggpool(int distance)
    {
        List<EggPoolEntityModel> eggPoolEntityModels = repo.findByEggDistance(distance);
        List<EggPoolServiceModel> eggPoolServiceModels = eggPoolEntityModels.stream().map(EggPoolPublicService::mapEntityToService).collect(Collectors.toList());
        
        return eggPoolServiceModels;
    }

    private static  EggPoolServiceModel mapEntityToService(EggPoolEntityModel entityModel)
    {
        EggPoolServiceModel serviceModel = new EggPoolServiceModel();

        serviceModel.setPokemon(entityModel.getPokemon());
        serviceModel.setEggDistance(entityModel.getEggDistance());
        serviceModel.setMinCp(entityModel.getMinCp());
        serviceModel.setMaxCp(entityModel.getMaxCp());
        serviceModel.setShinyAvailable(entityModel.getShinyAvailable());

        return serviceModel;
    }
}
