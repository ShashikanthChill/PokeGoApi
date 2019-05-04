/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.models.entitymodels;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "type_weather_boost")
public class TypeWeatherBoostEntityModel implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "weather")
    private String weather;

    public TypeWeatherBoostEntityModel()
    {
    }

    public TypeWeatherBoostEntityModel(Integer id)
    {
        this.id = id;
    }

    public TypeWeatherBoostEntityModel(Integer id, String type, String weather)
    {
        this.id = id;
        this.type = type;
        this.weather = weather;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getWeather()
    {
        return weather;
    }

    public void setWeather(String weather)
    {
        this.weather = weather;
    }

    @Override
    public String toString()
    {
        return "TypeWeatherBoostModel: {" + "id=" + id + ", type=" + type + ", weather=" + weather + '}';
    }

}
