/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.models.servicemodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author The_Humble_Fool
 */
@JsonRootName(value = "Type Effectiveness Data")
public class TypeEffectivenessServiceModel implements Serializable
{

    private String type;

    private List<String> superEffective = new ArrayList<>();

    private List<String> normalEffective = new ArrayList<>();

    private List<String> notVeryEffective = new ArrayList<>();

    private List<String> noEffective = new ArrayList<>();

    public TypeEffectivenessServiceModel()
    {
    }

    public TypeEffectivenessServiceModel(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    @JsonProperty(value = "Type")
    public void setType(String type)
    {
        this.type = type;
    }

    @JsonProperty(value = "Super Effective")
    public List<String> getSuperEffective()
    {
        return superEffective;
    }

    public void setSuperEffective(List<String> superEffective)
    {
        this.superEffective = superEffective;
    }

    @JsonProperty(value = "Nomal Effective")
    public List<String> getNormalEffective()
    {
        return normalEffective;
    }

    public void setNormalEffective(List<String> normalEffective)
    {
        this.normalEffective = normalEffective;
    }

    @JsonProperty(value = "Not Very Effective")
    public List<String> getNotVeryEffective()
    {
        return notVeryEffective;
    }

    public void setNotVeryEffective(List<String> notVeryEffective)
    {
        this.notVeryEffective = notVeryEffective;
    }

    @JsonProperty(value = "Zero Effective")
    public List<String> getNoEffective()
    {
        return noEffective;
    }

    public void setNoEffective(List<String> noEffective)
    {
        this.noEffective = noEffective;
    }

}
