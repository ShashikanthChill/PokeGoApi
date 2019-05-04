/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_humble_fool.PokeGoApi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author The_Humble_Fool
 */
@Controller
public class MainController
{

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String welcomePage()
    {
        return "welcome";
    }

}
