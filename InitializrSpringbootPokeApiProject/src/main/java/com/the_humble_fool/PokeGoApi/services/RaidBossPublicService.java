/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.services;

import com.the_humble_fool.PokeGoApi.jparepositories.RaidBossJpaRepo;
import com.the_humble_fool.PokeGoApi.models.entitymodels.RaidBossEntityModel;
import com.the_humble_fool.PokeGoApi.models.servicemodels.RaidBossServiceModel;
import java.sql.ResultSet;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author The_Humble_Fool
 */
@Service
public class RaidBossPublicService
{

    @Autowired
    RaidBossJpaRepo repo;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<RaidBossServiceModel> getAllRaidBosses()
    {
        List<RaidBossEntityModel> raidBossEntityModels = repo.findAll();
        List<RaidBossServiceModel> raidBossServiceModels = raidBossEntityModels.stream().map(RaidBossPublicService::mapEntityToService).map((t) -> {
            return addWeathers(t, jdbcTemplate);
        }).collect(Collectors.toList());

        return raidBossServiceModels;
    }

    public List<RaidBossServiceModel> getTieredRaidBosses(int tier)
    {
        List<RaidBossEntityModel> raidBossEntityModels = repo.findByTier(tier);
        List<RaidBossServiceModel> raidBossServiceModels = raidBossEntityModels.stream().map(RaidBossPublicService::mapEntityToService).map((t) -> {
            return addWeathers(t, jdbcTemplate);
        }).collect(Collectors.toList());

        return raidBossServiceModels;
    }

    public List<RaidBossServiceModel> getNamedRaidBoss(String raidboss)
    {
        List<RaidBossEntityModel> raidBossEntityModels = repo.findByRaidBossStartingWith(raidboss);
        List<RaidBossServiceModel> raidBossServiceModels = raidBossEntityModels.stream().map(RaidBossPublicService::mapEntityToService).map((t) -> {
            return addWeathers(t, jdbcTemplate);
        }).collect(Collectors.toList());

        return raidBossServiceModels;
    }

    private  static RaidBossServiceModel mapEntityToService(RaidBossEntityModel entityModel)
    {
        RaidBossServiceModel serviceModel = new RaidBossServiceModel();

        serviceModel.setPokeDex(entityModel.getPokeDex());
        serviceModel.setRaidBoss(entityModel.getRaidBoss());
        serviceModel.getType().add(entityModel.getType1());

        if (entityModel.getType2() != null) {
            serviceModel.getType().add(entityModel.getType2());
        }

        serviceModel.setTier(entityModel.getTier() == 6 ? "EX" : String.valueOf(entityModel.getTier()));
        serviceModel.setGen(entityModel.getGen());
        serviceModel.setRaidBossCp(entityModel.getRaidBossCp());
        serviceModel.setMinCpNonBoosted(entityModel.getMinCpNonBoosted());
        serviceModel.setMaxCpNonBoosted(entityModel.getMaxCpNonBoosted());
        serviceModel.setMinCpBoosted(entityModel.getMinCpBoosted());
        serviceModel.setMaxCpBoosted(entityModel.getMaxCpBoosted());
        serviceModel.setGroupSizeDifficulty(entityModel.getGroupSizeDifficulty());
        serviceModel.setCatchRate(entityModel.getCatchRate());
        serviceModel.setShinyAvailable(entityModel.getShinyAvailable());

        return serviceModel;
    }

    private  static RaidBossServiceModel addWeathers(RaidBossServiceModel model, JdbcTemplate template)
    {
        List<String> types = model.getType();
        types.forEach((x) -> {
            template.query("select weather from type_weather_boost where type='" + x + "'", (ResultSet rs, int rowNum) -> {
                rs.beforeFirst();
                rs.next();
                model.getBoostedWeather().add(rs.getString(1));
                return model;
            });
        });

        return model;
    }
}
