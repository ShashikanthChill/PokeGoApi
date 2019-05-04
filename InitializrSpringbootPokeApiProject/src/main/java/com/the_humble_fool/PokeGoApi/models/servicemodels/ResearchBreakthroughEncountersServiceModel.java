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
@JsonRootName(value = "Research Breakthrough Encounters Data")
@JsonPropertyOrder(value = {"pokedex", "pokemon", "minCp", "maxCp", "shinyAvailable"})
public class ResearchBreakthroughEncountersServiceModel implements Serializable
{

    private int pokeDex;

    private String pokemon;

    private int minCp;

    private int maxCp;

    private boolean shinyAvailable;

    public ResearchBreakthroughEncountersServiceModel()
    {
    }

    public ResearchBreakthroughEncountersServiceModel(int pokeDex, String pokemon, int minCp, int maxCp, boolean shinyAvailable)
    {
        this.pokeDex = pokeDex;
        this.pokemon = pokemon;
        this.minCp = minCp;
        this.maxCp = maxCp;
        this.shinyAvailable = shinyAvailable;
    }

    @JsonProperty(value = "Poke Index")
    public int getPokeDex()
    {
        return pokeDex;
    }

    public void setPokeDex(int pokeDex)
    {
        this.pokeDex = pokeDex;
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
        return "ResearchBreakthroughEncountersServiceModel: {" + "pokedex=" + pokeDex + ", pokemon=" + pokemon + ", minCp=" + minCp + ", maxCp=" + maxCp + ", shinyAvailable=" + shinyAvailable + '}';
    }

}
