package com.revature;

import com.revature.controller.WeatherController;

import io.javalin.Javalin;

/**
 *  Javalin
 * 
 *      Javalin is a framework for building a RESTful API
 *      Most of the work with Javalin is building endpoints
 * 
 *      A few keywords here:
 *          REST - set of constraints for defining how an API behaves
 *                 more on this Thursday
 * 
 *          Endpoint
 *               - This refers to the name of the resource within an API
 *               - In a request, this comes after the URL
 *                 In the URL "http://localhost:8080/hello" the endpoint is "hello"
 * 
 *          Handler
 *               - This is the method that we register with our Javalin app
 *               - Defines what to do when an endpoint is 'hit' (receives a certain request)
 *               - Is actually a functional interface which we will implement
 *                 This is why we can use method reference or lambda syntax when registering
 * 
 *          Context
 *               - This is an object that Javalin passes into our handler method
 *               - Wraps around the http request and response
 *               - provides methods for getting info from the request and setting it for the response
 * 
 *          JSON
 *               - Javascript Object Notation
 *               - Not related to Java, this is a common way to represent objects in http
 *               - mentioned because we will be sending objects as JSON Strings
 *               - We can convert these using the context object or an Oject Mapper
 * 
 *          Object Mapper
 *               - Just a library for converting Java objects to JSON and vice versa
 *               - Javalin uses Jackson for this
 *               - GSON is another common object mapper for java to JSON
 *
 */
public class App 
{
    /**
     * This method will be pretty barebones from now on
     * 
     * It's only purpose is going to be to setup and launch the Javalin app
     * since Javalin will run on it's own
     */
    public static void main( String[] args )
    {
        WeatherController controller = new WeatherController();
        Javalin app = controller.startApi();
        app.start(8000);
    }

}
