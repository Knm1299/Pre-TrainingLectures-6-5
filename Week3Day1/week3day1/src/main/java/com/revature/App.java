package com.revature;

import java.util.ArrayList;

/**
 *  4 Pillars of OOP
 *      Essentially 4 key concepts that together form the backbone of the Object Oriented programming paradigm
 *      Today we will cover 3 of them
 * 
 * ------------------------------------------------------------------------------------------
 * 
 *  Inheritance
 *      Inheritance is a relationship between two classes, where one 'extends' the other
 *          When a class extends another, it's as if the new class is added to the bottom of the old one.
 *          It gains access to all states and behaviors of the first class
 *      We refer to the first class as the 'Parent' class or 'Super' class
 *      The other class would then be the 'Child' class or the 'Sub' class
 *      
 *      All classes extend the Object class, even if not explicitly written.
 * 
 *      You can only extend one class at a time
 *          'Multiple Inheritance' - extending more than one class in a single subclass
 *      
 * 
 * ------------------------------------------------------------------------------------------
 * 
 *  Encapsulation
 *      Encapsulation is controlling where you can access the states or behaviors of objects
 *      We can do this using access modifiers
 * 
 *      There are 4 access levels, meaning 3 access modifiers, and the default access level if no modifier is added
 * 
 *      The modifiers are:
 *          public    - accessible anywhere
 *          private   - only accessible in the same class(only useable by that object itself)
 *          protected - accessible in the same package as the class, or in subclasses outside of that package
 * 
 *      The default access level is accessible in the same package, not outside of that package though.
 * 
 * 
 *      when creating a field for an object(property, state), we typically make these private.
 *          
 * 
 * ------------------------------------------------------------------------------------------
 * 
 *  Polymorphism
 * 
 *      Method Overloading - Compile time Polymorphism/Static Polymorphism
 *          same name, different signature(different parameter type or order)
 *          creating two methods with different parameter lists and different method bodies/code blocks/implementations 
 *              in the same class
 *          can be done with multiple methods
 * 
 *      Method Overriding - Runtime Polymoprphism/Dynamic Polymorphism
 *          when we inherit a method, we can redeclare the same method(same signature) with a different implementation
 *          referred to the same as the method that was inherited(same signature)
 * 
 * ------------------------------------------------------------------------------------------
 * 
 *      Polymorphic covariance
 *          an object created from a subclass is simultaneously an instance of the sub and super classes.
 *          a String IS AN Object
 *          a Student IS A Person
 * 
 */
public class App {
    public static void main( String[] args ){
        Student s = new Student();
        Person p = new Person();
        Teacher t = new Teacher();

        // s.name = "person from within student";
        s.setName("person from within student");
        // p.name = "person from person class";
        p.setName("person from person class");

        // ArrayList<Person> people = new ArrayList<>();
        // people.add(s);

        p.speak();
        s.speak();

    }
}

class Person extends Object{
    private String name;
    int age;

    public Person(){
        this("default name");
    }

    public Person(String name){
        this.name = name;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void speak(){
        System.out.println("The person speaks");
    }

    //getters and setters
    //accessors and mutators

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}

class Student extends Person{

    public Student(){
        // super("default name");
        this.setName("default name");
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public void speak(){
        System.out.println("...");
    }
}

class Teacher extends Student{

}