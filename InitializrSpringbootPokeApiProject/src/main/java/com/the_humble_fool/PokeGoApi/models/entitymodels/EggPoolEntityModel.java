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
@Table(name = "egg_pool_list")
public class EggPoolEntityModel implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "pokemon")
    private String pokemon;

    @Column(name = "egg_distance")
    private int eggDistance;

    @Column(name = "min_cp")
    private int minCp;

    @Column(name = "max_cp")
    private int maxCp;

    @Column(name = "shiny_available")
    private boolean shinyAvailable;

    public EggPoolEntityModel()
    {
    }

    public EggPoolEntityModel(Integer id)
    {
        this.id = id;
    }

    public EggPoolEntityModel(Integer id, String pokemon, int eggDistance, int minCp, int maxCp, boolean shinyAvailable)
    {
        this.id = id;
        this.pokemon = pokemon;
        this.eggDistance = eggDistance;
        this.minCp = minCp;
        this.maxCp = maxCp;
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

    public String getPokemon()
    {
        return pokemon;
    }

    public void setPokemon(String pokemon)
    {
        this.pokemon = pokemon;
    }

    public int getEggDistance()
    {
        return eggDistance;
    }

    public void setEggDistance(int eggDistance)
    {
        this.eggDistance = eggDistance;
    }

    public int getMinCp()
    {
        return minCp;
    }

    public void setMinCp(int minCp)
    {
        this.minCp = minCp;
    }

    public int getMaxCp()
    {
        return maxCp;
    }

    public void setMaxCp(int maxCp)
    {
        this.maxCp = maxCp;
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
        return "EggPoolEntityModel: {" + "id=" + id + ", pokemon=" + pokemon + ", eggDistance=" + eggDistance + ", minCp=" + minCp + ", maxCp=" + maxCp + ", shinyAvailable=" + shinyAvailable + '}';
    }

}
