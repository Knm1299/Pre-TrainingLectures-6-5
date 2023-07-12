package com.revature.service;

import java.util.List;

import com.revature.dao.WeatherDAO;
import com.revature.dao.WeatherDAOImpl;
import com.revature.model.Weather;

public class WeatherService {
    private WeatherDAO dao = null;

    public WeatherService(){
        //We would instantiate an implementation of WeatherDAO here
        // dao = new WeatherDAOImpl();
    }

    public WeatherService(WeatherDAO dao){
        this.dao = dao;
    }

    public Weather addWeather(Weather newWeather){
        return dao.insertWeather(newWeather);
    }

    public List<Weather> getAllWeather(){
        return dao.getAllWeather();
    }

    //Optional: add another method with complex logic to make mocking it valuable, add tests as well

}
