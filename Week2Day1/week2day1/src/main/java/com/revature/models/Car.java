package com.revature.models;

/**
 * Simple class, used to represent different scopes
 */
public class Car {
    //object(instance) scoped variable
    public int topSpeed;
    //When we create a new car, we get a new topSpeed to hold data

    //static(class) scoped variable
    public static boolean hasWheels;
    //When we create a new car, we don't get a new 

    public static void printWheels(){
        System.out.println(hasWheels);
    }

    public Car(){
        int topSpeed = 100;

        this.topSpeed = topSpeed;
    }
    
}
