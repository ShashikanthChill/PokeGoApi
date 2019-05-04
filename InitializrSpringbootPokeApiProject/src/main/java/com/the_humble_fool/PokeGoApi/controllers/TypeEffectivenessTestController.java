/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.controllers;

import com.the_humble_fool.PokeGoApi.exceptions.PokemonTypeNotFoundException;
import com.the_humble_fool.PokeGoApi.models.servicemodels.TypeEffectivenessServiceModel;
import com.the_humble_fool.PokeGoApi.services.TypeEffectivenessPublicService;
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
@RequestMapping(path = "public-api/effectiveness")
public class TypeEffectivenessTestController
{

    @Autowired
    TypeEffectivenessPublicService service;

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TypeEffectivenessServiceModel> AllTypesHandler()
    {
        return service.getAllTypeEffectives();
    }

    @RequestMapping(path = "{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TypeEffectivenessServiceModel> SpecificTypeHandler(@PathVariable(value = "type") String type)
    {
        
        List<TypeEffectivenessServiceModel> specificTypeEffectives = service.getSpecificTypeEffectives(type);
        if (specificTypeEffectives == null || specificTypeEffectives.isEmpty()) {
            throw new PokemonTypeNotFoundException("Pokemon Type: `" + type + "` not found.");
        }
        return specificTypeEffectives;
    }
}
