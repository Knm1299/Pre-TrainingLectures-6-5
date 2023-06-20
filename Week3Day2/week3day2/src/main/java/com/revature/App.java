package com.revature;

import java.util.ArrayList;
import java.util.List;

/**
 *  Abstraction
 *      Abstraction is the 4th of the 4 Pillars of OOP.
 *      This is the idea that we can generalize behavior into interfaces or abstract classes, and only ever implement that behavior in subtypes
 *      
 *      Interfaces
 *          Just define beavior
 *          Define the signatures of methods that we will implement in 'concrete' classes
 *          these are implemented in classes, rather than extended
 *          variables are implicitly public static final by default(constants)
 *          cannot have constructors, cannot be instantiated
 * 
 *      Abstract classes
 *          can define state and behavior
 *          These are essentially just classes that contain abstract(unimplemented) methods
 *          these are extended rather than implemented
 *          can have constructors, but can't be instantiated
 * 
 * ------------------------------------------------------------------------------------------
 * 
 *  SOLID principles
 *      Principles that describe Object Oriented code that is easy to read and maintain
 *      These are relevant long term rather than short term
 *      
 *      Not something to guide your every move, but a few key points that make larger systems easier to work with for longer
 *      
 *      The 5 principles are as follows:
 *          Single Responsibility
 *              Group code that changes for the same reason together
 *              When will we change this class? Why will it change?
 *          Open/Closed
 *              Classes are open to extension but closed to modification
 *              When adding a new behavior, it's often better to create a subclass rather than modifying a parent class
 *          Liskov Substitution
 *              Subtypes should be useable in place of supertypes
 *                  essentially, if a subtye exists, it must be usable in any place the super type was
 *              When creating child classes(subtypes) the child class must be useable in any place the parent class was
 *          Interface Segregation
 *              When writing interfaces, prefer more numerous specific interfaces to fewer but overly broad ones
 *                  this reduces the amount of things that need to be modified for a change, 
 *                  and makes class signatures more descriptive as to their capabilities
 *          Dependency Inversion
 *              prefer to use supertypes for parts that may change
 *              see also 'coding to the interface'
 *              Essentially, if the specific implementation of an interface is likely to change, write your code to use the interface as much as possible, so that if the implementation changes, you can reduce the number of individual changes needed
 *              
 *              Note: this rule isn't necessarily about interfaces, classes can be used for this as well, as long as you follow the Liskov Substitution Principle
 *
 */
public class App {
    public static void main( String[] args ){
        CRUD dataStore = new ArrayListCRUDImpl();

        //same idea, using the supertype as our reference type, instantiating the concrete class
        List<String> strings = new ArrayList<>();


        System.out.println(CRUD.NUMBER);
    }

}
