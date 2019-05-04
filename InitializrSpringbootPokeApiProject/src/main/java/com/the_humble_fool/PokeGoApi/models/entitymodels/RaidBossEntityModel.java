/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.models.entitymodels;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author The_Humble_Fool
 */
@Entity
@Table(name = "raid_boss_list")
public class RaidBossEntityModel implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "poke_dex")
    private int pokeDex;

    @Column(name = "raid_boss")
    private String raidBoss;

    @Column(name = "type_1")
    private String type1;

    @Column(name = "type_2")
    private String type2;

    @Column(name = "tier")
    private int tier;

    @Column(name = "gen")
    private int gen;

    @Column(name = "raid_boss_cp")
    private int raidBossCp;

    @Column(name = "min_cp_non_boosted")
    private int minCpNonBoosted;

    @Column(name = "max_cp_non_boosted")
    private int maxCpNonBoosted;

    @Column(name = "min_cp_boosted")
    private int minCpBoosted;

    @Column(name = "max_cp_boosted")
    private int maxCpBoosted;

    @Column(name = "group_size_difficulty")
    private int groupSizeDifficulty;

    @Column(name = "catch_rate")
    private double catchRate;

    @Column(name = "shiny_available")
    private boolean shinyAvailable;

    public RaidBossEntityModel()
    {
    }

    public RaidBossEntityModel(Integer id)
    {
        this.id = id;
    }

    public RaidBossEntityModel(Integer id, int pokeDex, String raidBoss, String type1, int tier, int gen, int raidBossCp, int minCpNonBoosted, int maxCpNonBoosted, int minCpBoosted, int maxCpBoosted, int groupSizeDifficulty, double catchRate, boolean shinyAvailable)
    {
        this.id = id;
        this.pokeDex = pokeDex;
        this.raidBoss = raidBoss;
        this.type1 = type1;
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

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public int getPokeDex()
    {
        return pokeDex;
    }

    public void setPokeDex(int pokeDex)
    {
        this.pokeDex = pokeDex;
    }

    public String getRaidBoss()
    {
        return raidBoss;
    }

    public void setRaidBoss(String raidBoss)
    {
        this.raidBoss = raidBoss;
    }

    public String getType1()
    {
        return type1;
    }

    public void setType1(String type1)
    {
        this.type1 = type1;
    }

    public String getType2()
    {
        return type2;
    }

    public void setType2(String type2)
    {
        this.type2 = type2;
    }

    public int getTier()
    {
        return tier;
    }

    public void setTier(int tier)
    {
        this.tier = tier;
    }

    public int getGen()
    {
        return gen;
    }

    public void setGen(int gen)
    {
        this.gen = gen;
    }

    public int getRaidBossCp()
    {
        return raidBossCp;
    }

    public void setRaidBossCp(int raidBossCp)
    {
        this.raidBossCp = raidBossCp;
    }

    public int getMinCpNonBoosted()
    {
        return minCpNonBoosted;
    }

    public void setMinCpNonBoosted(int minCpNonBoosted)
    {
        this.minCpNonBoosted = minCpNonBoosted;
    }

    public int getMaxCpNonBoosted()
    {
        return maxCpNonBoosted;
    }

    public void setMaxCpNonBoosted(int maxCpNonBoosted)
    {
        this.maxCpNonBoosted = maxCpNonBoosted;
    }

    public int getMinCpBoosted()
    {
        return minCpBoosted;
    }

    public void setMinCpBoosted(int minCpBoosted)
    {
        this.minCpBoosted = minCpBoosted;
    }

    public int getMaxCpBoosted()
    {
        return maxCpBoosted;
    }

    public void setMaxCpBoosted(int maxCpBoosted)
    {
        this.maxCpBoosted = maxCpBoosted;
    }

    public int getGroupSizeDifficulty()
    {
        return groupSizeDifficulty;
    }

    public void setGroupSizeDifficulty(int groupSizeDifficulty)
    {
        this.groupSizeDifficulty = groupSizeDifficulty;
    }

    public double getCatchRate()
    {
        return catchRate;
    }

    public void setCatchRate(double catchRate)
    {
        this.catchRate = catchRate;
    }

    public boolean getShinyAvailable()
    {
        return shinyAvailable;
    }

    public void setShinyAvailable(boolean shinyAvailable)
    {
        this.shinyAvailable = shinyAvailable;
    }

    @Override
    public String toString()
    {
        return "RaidBossEntityModel: {" + "id=" + id + ", pokeDex=" + pokeDex + ", raidBoss=" + raidBoss + ", type1=" + type1 + ", type2=" + type2 + ", tier=" + tier + ", gen=" + gen + ", raidBossCp=" + raidBossCp + ", minCpNonBoosted=" + minCpNonBoosted + ", maxCpNonBoosted=" + maxCpNonBoosted + ", minCpBoosted=" + minCpBoosted + ", maxCpBoosted=" + maxCpBoosted + ", groupSizeDifficulty=" + groupSizeDifficulty + ", catchRate=" + catchRate + ", shinyAvailable=" + shinyAvailable + '}';
    }



}
