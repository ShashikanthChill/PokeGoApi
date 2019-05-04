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
@Table(name = "research_breakthrough_encounters_list")
public class ResearchBreakthroughEncountersEntityModel implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "pokedex")
    private int pokeDex;

    @Column(name = "pokemon")
    private String pokemon;

    @Column(name = "min_cp")
    private int minCp;

    @Column(name = "max_cp")
    private int maxCp;

    @Column(name = "shiny_available")
    private boolean shinyAvailable;

    public ResearchBreakthroughEncountersEntityModel()
    {
    }

    public ResearchBreakthroughEncountersEntityModel(Integer id)
    {
        this.id = id;
    }

    public ResearchBreakthroughEncountersEntityModel(Integer id, int pokeDex, String pokemon, int minCp, int maxCp, boolean shinyAvailable)
    {
        this.id = id;
        this.pokeDex = pokeDex;
        this.pokemon = pokemon;
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

    public int getPokeDex()
    {
        return pokeDex;
    }

    public void setPokeDex(int pokeDex)
    {
        this.pokeDex = pokeDex;
    }

    public String getPokemon()
    {
        return pokemon;
    }

    public void setPokemon(String pokemon)
    {
        this.pokemon = pokemon;
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
        return "ResearchBreakthroughEncountersEntityModel: {" + "id=" + id + ", pokedex=" + pokeDex + ", pokemon=" + pokemon + ", minCp=" + minCp + ", maxCp=" + maxCp + ", shinyAvailable=" + shinyAvailable + '}';
    }

}
