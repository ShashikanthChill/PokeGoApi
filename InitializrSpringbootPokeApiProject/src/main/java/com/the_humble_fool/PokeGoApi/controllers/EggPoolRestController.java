/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.controllers;

import com.the_humble_fool.PokeGoApi.exceptions.EggpoolNotFoundException;
import com.the_humble_fool.PokeGoApi.models.servicemodels.EggPoolServiceModel;
import com.the_humble_fool.PokeGoApi.services.EggPoolPublicService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author The_Humble_Fool
 */
@RestController
@RequestMapping(path = "public-api/eggs")
public class EggPoolRestController
{

    @Autowired
    EggPoolPublicService service;

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<EggPoolServiceModel> AllEggPoolsHandler()
    {
        return service.getAllEggpools();
    }

    @RequestMapping(path = "{distance}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<EggPoolServiceModel> DistanceBasedEggPoolsHandler(@PathVariable("distance") int distance)
    {
        List<EggPoolServiceModel> distancedEggpools = service.getDistancedEggpool(distance);
        if (distancedEggpools == null || distancedEggpools.isEmpty()) {
            throw new EggpoolNotFoundException("No Eggs found in " + distance + "km pool.");
        }
        return distancedEggpools;
    }
}
