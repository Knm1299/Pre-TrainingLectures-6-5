package com.revature.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.dao.WeatherDAO;
import com.revature.model.Weather;

public class WeatherServiceTest {
    private WeatherService service = null;

    // @BeforeEach
    // public void setupService(){
    //     service = new WeatherService();
    // }

    @Test
    public void testAddWeather(){
        //mocking the DAO layer
        WeatherDAO mockDAO = mock(WeatherDAO.class);

        //creating our test object
        Weather testWeather = new Weather("Wednesday", 90.0, new double[]{90,91,92,91});

        //creating expected object
        Weather expectedWeather = new Weather(1, "Wednesday", 90.0, new double[]{90,91,92,91});

        //stubbing a method
        when(mockDAO.insertWeather(testWeather)).thenReturn(expectedWeather);

        service = new WeatherService(mockDAO);

        //Actually calling the service layer and retrieving the object
        Weather actualWeather = service.addWeather(testWeather);

        //Asserting that this object must not be null 
        assertNotNull(actualWeather);
        assertEquals(expectedWeather, actualWeather);
    }
    
}
