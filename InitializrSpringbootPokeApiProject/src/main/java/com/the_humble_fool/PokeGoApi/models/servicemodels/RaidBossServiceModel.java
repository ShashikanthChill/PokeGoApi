/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.models.servicemodels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author The_Humble_Fool
 */
@JsonRootName(value = "Raid Boss Data")
@JsonPropertyOrder(value = {"pokeDex", "raidBoss", "type1", "type2", "type", "boostedWeather", "gen", "tier", "raidBossCp", "minCpNonBoosted", "maxCpNonBoosted", "minCpBoosted", "maxCpBoosted", "groupSizeDifficulty", "catchRate", "shinyAailable"})
public class RaidBossServiceModel implements Serializable
{

    private int pokeDex;

    private String raidBoss;

//    @JsonProperty(value = "type1", access = JsonProperty.Access.WRITE_ONLY)
    private String type1;

//    @JsonProperty(value = "type2", access = JsonProperty.Access.WRITE_ONLY)
    private String type2;

//    @JsonProperty(value = "Type", access = JsonProperty.Access.READ_ONLY)
    private List<String> type = new ArrayList<>();

//    @JsonProperty(value = "Boosted Weather", access = JsonProperty.Access.READ_ONLY)
    private Set<String> boostedWeather = new HashSet<>();

    private String tier;

    private int gen;

    private int raidBossCp;

    private int minCpNonBoosted;

    private int maxCpNonBoosted;

    private int minCpBoosted;

    private int maxCpBoosted;

    private int groupSizeDifficulty;

    private double catchRate;

    private boolean shinyAvailable;

    public RaidBossServiceModel()
    {
    }

    public RaidBossServiceModel(int pokeDex, String raidBoss, String type1, String type2, String tier, int gen, int raidBossCp, int minCpNonBoosted, int maxCpNonBoosted, int minCpBoosted, int maxCpBoosted, int groupSizeDifficulty, double catchRate, boolean shinyAvailable)
    {
        this.pokeDex = pokeDex;
        this.raidBoss = raidBoss;
        this.type1 = type1;
        this.type2 = type2;
        this.tier = tier;
        this.gen = gen;
        this.raidBossCp = raidBossCp;
        this.minCpNonBoosted = minCpNonBoosted;
        this.maxCpNonBoosted = maxCpNonBoosted;
        this.minCpBoosted = minCpBoosted;
        this.maxCpBoosted = maxCpBoosted;
        this.groupSizeDifficulty = groupSizeDifficulty;
        this.catchRate = catchRate;
        this.shinyAvailable = shinyAvailable;
    }

//    public RaidBossServiceModel(int pokeDex, String raidBoss, String tier, int gen, int raidBossCp, int minCpNonBoosted, int maxCpNonBoosted, int minCpBoosted, int maxCpBoosted, int groupSizeDifficulty, double catchRate, boolean shinyAvailable)
//    {
//        this.pokeDex = pokeDex;
//        this.raidBoss = raidBoss;
//        this.tier = tier;
//        this.gen = gen;
//        this.raidBossCp = raidBossCp;
//        this.minCpNonBoosted = minCpNonBoosted;
//        this.maxCpNonBoosted = maxCpNonBoosted;
//        this.minCpBoosted = minCpBoosted;
//        this.maxCpBoosted = maxCpBoosted;
//        this.groupSizeDifficulty = groupSizeDifficulty;
//        this.catchRate = catchRate;
//        this.shinyAvailable = shinyAvailable;
//    }
    @JsonProperty(value = "Poke Index")
    public int getPokeDex()
    {
        return pokeDex;
    }

    public void setPokeDex(int pokeDex)
    {
        this.pokeDex = pokeDex;
    }

    @JsonProperty(value = "Raid Boss")
    public String getRaidBoss()
    {
        return raidBoss;
    }

    public void setRaidBoss(String raidBoss)
    {
        this.raidBoss = raidBoss;
    }

    @JsonIgnore
    public String getType1()
    {
        return type1;
    }

    @JsonProperty(value = "type1")
    public void setType1(String type1)
    {
        this.type1 = type1;
    }

    @JsonIgnore
    public String getType2()
    {
        return type2;
    }

    @JsonProperty(value = "type2")
    public void setType2(String type2)
    {
        this.type2 = type2;
    }

    @JsonProperty(value = "Type")
    public List<String> getType()
    {
        return type;
    }

    @JsonIgnore
    public void setType(List<String> type)
    {
        this.type = type;
    }

    @JsonProperty(value = "Boosted Weather")
    public Set<String> getBoostedWeather()
    {
        return boostedWeather;
    }

    @JsonIgnore
    public void setBoostedWeather(Set<String> boostedWeather)
    {
        this.boostedWeather = boostedWeather;
    }

    @JsonProperty(value = "Tier")
    public String getTier()
    {
        return tier;
    }

    public void setTier(String tier)
    {
        this.tier = tier;
    }

    @JsonProperty(value = "Generation")
    public int getGen()
    {
        return gen;
    }

    public void setGen(int gen)
    {
        this.gen = gen;
    }

    @JsonProperty(value = "Boss Cp")
    public int getRaidBossCp()
    {
        return raidBossCp;
    }

    public void setRaidBossCp(int raidBossCp)
    {
        this.raidBossCp = raidBossCp;
    }

    @JsonProperty(value = "Min Cp(Non-Boosted)")
    public int getMinCpNonBoosted()
    {
        return minCpNonBoosted;
    }

    public void setMinCpNonBoosted(int minCpNonBoosted)
    {
        this.minCpNonBoosted = minCpNonBoosted;
    }

    @JsonProperty(value = "Max Cp(Non-Boosted)")
    public int getMaxCpNonBoosted()
    {
        return maxCpNonBoosted;
    }

    public void setMaxCpNonBoosted(int maxCpNonBoosted)
    {
        this.maxCpNonBoosted = maxCpNonBoosted;
    }

    @JsonProperty(value = "Min Cp(Boosted)")
    public int getMinCpBoosted()
    {
        return minCpBoosted;
    }

    public void setMinCpBoosted(int minCpBoosted)
    {
        this.minCpBoosted = minCpBoosted;
    }

    @JsonProperty(value = "Max Cp(Boosted)")
    public int getMaxCpBoosted()
    {
        return maxCpBoosted;
    }

    public void setMaxCpBoosted(int maxCpBoosted)
    {
        this.maxCpBoosted = maxCpBoosted;
    }

    @JsonProperty(value = "Recommended Group Size")
    public int getGroupSizeDifficulty()
    {
        return groupSizeDifficulty;
    }

    public void setGroupSizeDifficulty(int groupSizeDifficulty)
    {
        this.groupSizeDifficulty = groupSizeDifficulty;
    }

    @JsonProperty(value = "Catch Rate")
    public double getCatchRate()
    {
        return catchRate;
    }

    public void setCatchRate(double catchRate)
    {
        this.catchRate = catchRate;
    }

    @JsonProperty(value = "Shiny Availability")
    public boolean getShinyAvailable()
    {
        return shinyAvailable;
    }

    public void setShinyAvailable(boolean shinyAvailable)
    {
        this.shinyAvailable = shinyAvailable;
    }

//    @Override
//    public String toString()
//    {
//        return "RaidBoss: {" + "pokeDex=" + pokeDex + ", raidBoss=" + raidBoss + ", type1=" + type1 + ", type2=" + type2 + ", tier=" + tier + ", gen=" + gen + ", raidBossCp=" + raidBossCp + ", minCpNonBoosted=" + minCpNonBoosted + ", maxCpNonBoosted=" + maxCpNonBoosted + ", minCpBoosted=" + minCpBoosted + ", maxCpBoosted=" + maxCpBoosted + ", groupSizeDifficulty=" + groupSizeDifficulty + ", catchRate=" + catchRate + ", shinyAvailable=" + shinyAvailable + '}';
//    }
//    @Override
//    public String toString()
//    {
//        return "RaidBossServiceModel: {" + "pokeDex=" + pokeDex + ", raidBoss=" + raidBoss + ", type=" + type + ", tier=" + tier + ", gen=" + gen + ", raidBossCp=" + raidBossCp + ", minCpNonBoosted=" + minCpNonBoosted + ", maxCpNonBoosted=" + maxCpNonBoosted + ", minCpBoosted=" + minCpBoosted + ", maxCpBoosted=" + maxCpBoosted + ", groupSizeDifficulty=" + groupSizeDifficulty + ", catchRate=" + catchRate + ", shinyAvailable=" + shinyAvailable + '}';
//    }

    @Override
    public String toString()
    {
        return "RaidBossServiceModel{" + "pokeDex=" + pokeDex + ", raidBoss=" + raidBoss + ", type1=" + type1 + ", type2=" + type2 + ", type=" + type + ", boostedWeather=" + boostedWeather + ", tier=" + tier + ", gen=" + gen + ", raidBossCp=" + raidBossCp + ", minCpNonBoosted=" + minCpNonBoosted + ", maxCpNonBoosted=" + maxCpNonBoosted + ", minCpBoosted=" + minCpBoosted + ", maxCpBoosted=" + maxCpBoosted + ", groupSizeDifficulty=" + groupSizeDifficulty + ", catchRate=" + catchRate + ", shinyAvailable=" + shinyAvailable + '}';
    }
    
    

}
