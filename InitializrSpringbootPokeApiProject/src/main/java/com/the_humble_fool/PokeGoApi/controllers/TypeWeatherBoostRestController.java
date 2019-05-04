/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.controllers;

import com.the_humble_fool.PokeGoApi.models.servicemodels.SortedTypeWeatherBoostServiceModel;
import com.the_humble_fool.PokeGoApi.models.servicemodels.TypeWeatherBoostServiceModel;
import com.the_humble_fool.PokeGoApi.services.TypeWeatherBoostPublicService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author The_Humble_Fool
 */
@RestController
@RequestMapping(path = "public-api/types")
public class TypeWeatherBoostRestController
{

    @Autowired
    TypeWeatherBoostPublicService service;

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TypeWeatherBoostServiceModel> AllTypesHandler()
    {
        return service.getBoostedWeatherList();
    }

    @RequestMapping(path = "sorted", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection<SortedTypeWeatherBoostServiceModel> AllTypesSortedHandler()
    {
        return service.getSortedBoostedWeatherList();
    }   
}
