/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author The_Humble_Fool
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RaidBossNotFoundException extends RuntimeException
{

    public RaidBossNotFoundException()
    {
    }

    public RaidBossNotFoundException(String string)
    {
        super(string);
    }
    
}
