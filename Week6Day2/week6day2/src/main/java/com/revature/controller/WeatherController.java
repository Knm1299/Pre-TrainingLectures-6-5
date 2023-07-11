package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Weather;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class WeatherController {
    //oftentimes, we will keep a single reference to our service layer here
    List<Weather> weatherList;

    public WeatherController(){
        weatherList = new ArrayList<Weather>();
    }

    public Javalin startApi(){
        Javalin app = Javalin.create();

        app.get("hello", this::sayHello);

        app.post("weather", this::addWeather);

        app.get("weather", this::getAllWeather);

        return app;
    }

    void sayHello(Context ctx){
        ctx.json("Hello!");
    }

    void addWeather(Context ctx){
        Weather weather = ctx.bodyAsClass(Weather.class);

        //This is where we would call the service layer
        weatherList.add(weather);

        ctx.status(201);
    }

    void getAllWeather(Context ctx){
        ctx.json(weatherList);
    }

}
