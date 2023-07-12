package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.WeatherController;

import io.javalin.Javalin;


/**
 *  Today's topics:
 *      Logging with Logback
 *          Quick overview
 *          Adding dependency, where to put logback.xml, Logger, Appender, LoggerFactory
 * 
 *      Testing with Mockito
 *          Mocking
 *          Method stubbing
 *              refer to docs
 */
public class App 
{
    // public static Logger logger = LoggerFactory.getLogger(App.class);
    public static Logger logger = LoggerFactory.getLogger("THE LOGGER");

    public static void main( String[] args )
    {
        WeatherController controller = new WeatherController();
        Javalin app = controller.startApi();
        app.start(8080);

        //Making a log
        logger.info("The Application Has Started!");
    }

}
