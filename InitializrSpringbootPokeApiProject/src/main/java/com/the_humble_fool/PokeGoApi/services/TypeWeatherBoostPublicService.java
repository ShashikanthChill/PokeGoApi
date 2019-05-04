/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.services;

import com.the_humble_fool.PokeGoApi.jparepositories.TypeWeatherBoostJpaRepo;
import com.the_humble_fool.PokeGoApi.models.entitymodels.TypeWeatherBoostEntityModel;
import com.the_humble_fool.PokeGoApi.models.servicemodels.SortedTypeWeatherBoostServiceModel;
import com.the_humble_fool.PokeGoApi.models.servicemodels.TypeWeatherBoostServiceModel;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author The_Humble_Fool
 */
@Service
public class TypeWeatherBoostPublicService
{

    @Autowired
    TypeWeatherBoostJpaRepo repo;

    public List<TypeWeatherBoostServiceModel> getBoostedWeatherList()
    {
        List<TypeWeatherBoostEntityModel> weatherBoostEntityModels = repo.findAll();

        List<TypeWeatherBoostServiceModel> weatherBoostServiceModels = weatherBoostEntityModels.stream().map(TypeWeatherBoostPublicService::mapEntityToService).collect(Collectors.toList());

        return weatherBoostServiceModels;
    }

    private  static TypeWeatherBoostServiceModel mapEntityToService(TypeWeatherBoostEntityModel entityModel)
    {
        TypeWeatherBoostServiceModel serviceModel = new TypeWeatherBoostServiceModel();

        serviceModel.setType(entityModel.getType());
        serviceModel.setWeather(entityModel.getWeather());

        return serviceModel;
    }

    public Collection<SortedTypeWeatherBoostServiceModel> getSortedBoostedWeatherList()
    {
        List<TypeWeatherBoostEntityModel> weatherBoostEntityModels = repo.findAll();
        Map<String, SortedTypeWeatherBoostServiceModel> sortedTypeWeatherBoostServiceModelsMap = new HashMap<>();
        weatherBoostEntityModels.forEach((t) -> {
            if (sortedTypeWeatherBoostServiceModelsMap.containsKey(t.getWeather())) {
                sortedTypeWeatherBoostServiceModelsMap.get(t.getWeather()).getType().add(t.getType());
            } else {
                SortedTypeWeatherBoostServiceModel sortedModel = new SortedTypeWeatherBoostServiceModel();
                sortedModel.setWeather(t.getWeather());
                sortedModel.getType().add(t.getType());
                sortedTypeWeatherBoostServiceModelsMap.put(t.getWeather(), sortedModel);
            }
        });

        return sortedTypeWeatherBoostServiceModelsMap.values();
    }

}
