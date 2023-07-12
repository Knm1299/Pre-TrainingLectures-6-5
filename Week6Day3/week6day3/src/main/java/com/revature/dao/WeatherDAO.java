package com.revature.dao;

import java.util.List;

import com.revature.model.Weather;

public interface WeatherDAO {
    Weather insertWeather(Weather newWeather);
    List<Weather> getAllWeather();
    Weather getById(int id);
    void updateWeather(int id, Weather newDetails);
    boolean deleteWeather(int id);
}
