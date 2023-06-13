package com.revature;

import java.net.http.HttpConnectTimeoutException;

import com.revature.models.Car;

/**
 * Today's topic:
 *      Scopes
 *      
 *      What is Scope?
 *          Scope defines where(in code) a variable becomes available for use, and when it is no longer available.
 *          
 *      What scopes exist in Java?
 *          local
 *              method
 *              block
 *          class
 *              object(instance)
 *              proper(static) class scope
 * 
 * 
 * Also mentioned:
 *      Package declaration
 *          Essentially what package(folder) the file is in
 *          fully qualified class name(name of a class from the root of the project) starts with the package
 *
 */
public class App {
    
    static final int GLOBAL_VAR = 1;

    public static void main( String[] args ){
        //method scope
        //useable until the end of the method
        String helloWorld = "Hello World!";

        //method call
        //sum is not useable here in main, only in the add2 method
        add2(5);

        //System.out.println(sum);//not useable, sum only exists within add2

        if(true){
            //block scope
            //only useable until the end of the current code block
            int a = 5;
        }

        //a class is a blueprint for creating objects
        //a class defines a 'type' of object

        //The fully qualified class name tells java how to find a class from the src.main.java package
        Car c = new Car();
        
        c.topSpeed = 100;

        Car b = new Car();

        //even though we set topSpeed for c, the topSpeed of b is the default value
        System.out.println(b.topSpeed);

        Car.hasWheels = false;

        System.out.println(Car.hasWheels);

        //static allows us to create classes that we don't need to instantiate in order to use
        
        Car.printWheels();

        if(true){
            int i = 0;
            if(i < 10){
                // int i = 0;//can't do, since block inherits upper scope
            }
        }

    }

    public static void add2(int a){
        int sum = a + 2;

        System.out.println("Sum of value and 2: " +sum);
    }
}
