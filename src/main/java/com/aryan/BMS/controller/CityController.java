package com.aryan.BMS.controller;

import com.aryan.BMS.model.City;
import com.aryan.BMS.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    public City addCity(String name) {
        return cityService.addCity(name);
    }
}
