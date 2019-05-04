/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.controllers;

import com.the_humble_fool.PokeGoApi.exceptions.InvalidRequestParamException;
import com.the_humble_fool.PokeGoApi.exceptions.RaidBossNotFoundException;
import com.the_humble_fool.PokeGoApi.exceptions.RequestParamFormatException;
import com.the_humble_fool.PokeGoApi.models.servicemodels.RaidBossServiceModel;
import com.the_humble_fool.PokeGoApi.services.RaidBossPublicService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping(path = "public-api/raids")
public class RaidBossRestController
{

    @Autowired
    RaidBossPublicService service;

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<RaidBossServiceModel> AllRaidBossesHandler()
    {
        return service.getAllRaidBosses();
    }

    @RequestMapping(path = "filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<RaidBossServiceModel> FilteredRaidBossesHandler(@RequestParam Map<String, String> filterParams, HttpServletRequest hsr)
    {
        String filterParam = filterParams.keySet().iterator().next();
        switch (filterParam) {
            case "tier": {
                try {
                    int tier = Integer.parseInt(filterParams.get(filterParam));
                    List<RaidBossServiceModel> tieredRaidBosses = service.getTieredRaidBosses(tier);
                    if (tieredRaidBosses == null || tieredRaidBosses.isEmpty()) {
                        throw new RaidBossNotFoundException("Raid boss(s) not found for 'tier'=`" + tier + "`");
                    }
                    return tieredRaidBosses;
                } catch (NumberFormatException nfe) {
                    System.out.println("Nfe arised in FilteredRaidBossesHandler for param: 'tier', value: " + filterParams.get(filterParam) + ".");
                    throw new RequestParamFormatException("Unsupported value found for 'tier'=`" + filterParams.get(filterParam) + "`. Please refer to Api docs: http://localhost:8080/PokeApi/");
                }
            }

            case "boss": {

                String raidboss = filterParams.get(filterParam);
                List<RaidBossServiceModel> namedRaidBoss = service.getNamedRaidBoss(raidboss);
                if (namedRaidBoss == null || namedRaidBoss.isEmpty()) {
                    throw new RaidBossNotFoundException("Raid bosses not found for 'boss'=`" + raidboss + "`");
                }
                return namedRaidBoss;

            }
            default:
                throw new InvalidRequestParamException("Invalid request parameter: '" + filterParam + "'. Please refer to Api docs: http://localhost:8080/PokeApi/");
        }
    }
}
