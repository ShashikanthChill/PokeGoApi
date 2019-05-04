/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.models.servicemodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;

/**
 *
 * @author The_Humble_Fool
 */

@JsonRootName(value = "Egg Pool Data")
@JsonPropertyOrder(value = {"eggDistance","pokemon","minCp","maxCp","shinyAvailable"})
public class EggPoolServiceModel implements Serializable
{

    private String pokemon;

    private int eggDistance;

    private int minCp;

    private int maxCp;

    private boolean shinyAvailable;

    public EggPoolServiceModel()
    {
    }

    public EggPoolServiceModel(String pokemon, int eggDistance, int minCp, int maxCp, boolean shinyAvailable)
    {
        this.pokemon = pokemon;
        this.eggDistance = eggDistance;
        this.minCp = minCp;
        this.maxCp = maxCp;
        this.shinyAvailable = shinyAvailable;
    }

    @JsonProperty(value = "Pokemon")
    public String getPokemon()
    {
        return pokemon;
    }

    public void setPokemon(String pokemon)
    {
        this.pokemon = pokemon;
    }

    @JsonProperty(value = "Egg Distance")
    public int getEggDistance()
    {
        return eggDistance;
    }

    public void setEggDistance(int eggDistance)
    {
        this.eggDistance = eggDistance;
    }

    @JsonProperty(value = "Min Cp")
    public int getMinCp()
    {
        return minCp;
    }

    public void setMinCp(int minCp)
    {
        this.minCp = minCp;
    }

    @JsonProperty(value = "Max Cp")
    public int getMaxCp()
    {
        return maxCp;
    }

    public void setMaxCp(int maxCp)
    {
        this.maxCp = maxCp;
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

    @Override
    public String toString()
    {
        return "EggPoolServiceModel: {pokemon=" + pokemon + ", eggDistance=" + eggDistance + ", minCp=" + minCp + ", maxCp=" + maxCp + ", shinyAvailable=" + shinyAvailable + '}';
    }

}
