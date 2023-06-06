package com.revature;

import java.io.OutputStream;

/**
 * Today's topic: Dataypes
 * 
 * Java is statically typed, which means that every varaible we create has a particular data type, which specifies what kind of data the variable can store.
 * 
 * There are two kinds of datatypes in Java:
 *  Primitive datatypes
 *      These are the 'built in' datatypes, which store data in relatively simple formats
 *      All lowercase, most are abbreviated
 *    The primitive types are:
 *      Whole numbers:
 *      byte  - 8 bits or 1 byte   - 256 total possible combinations, -128 to 127
 *      short - 16 bits or 2 bytes 
 *      int   - 32 bits or 4 bytes - default
 *      long  - 64 bits or 8 bytes
 * 
 *      Floating point numbers - stored in scientific notation
 *      float - 32 bits
 *      double- 64 bits default
 * 
 *      char   - a single character
 * 
 *      boolean- true or false
 * 
 *  Object - Any entity containing both State and Behavior
 *              States    - variables, properties, fields - a named place in memory
 *              Behaviors - Methods - a named group of code that is reusable
 * 
 *  Classes
 *      Almost all Java code will be contained within classes
 *      Classes are the 'blueprints' of objects, describing the states and behaviors(variables and methods) that it's objects will contain
 *      Since we can create variables to store objects, the datatype of those objects would be their associated classes
 *      
 */
public class App {
    public static void main( String[] args ){

        int i = 1;//Declaring and initializing a variable
        long longNumber = 99999999999l;
        
        float f;//Declaring a variable
        f = 12.34f;

        f = Float.MAX_VALUE;

        char c = 'a';
        System.out.println(c);

        boolean b = true;

        String s = "Hello \"World!\"";
        
        System.out.println(s.length());

        //String methods
        /*
         * toUppercase/toLowercase
         * split
         * charAt
         * length
         * equals()
         * equalsIgnoreCase()
         */

         /*
          * Operators
            Math
            +
            -
            *
            /

            % - remainder

            Unary mathmatical operators
            ++
            --
            <<
            >>

            Logical operators
            !
            &&
            ||
            ^

            Comparison operators
            <
            >
            <=
            >=
            ==
            !=

          */

         int sum = 1+1;
         boolean and = !true;

         boolean greater = 1 == 1;

         String s1 = new String("Hello World!");//calling a constructor, creating a new object, and returns a reference to that object
         String s2 = new String("Hello World!");

         s2 = s1;

         boolean sameObject = s1 == s2;

         System.out.println(s1.equals(s2));

         int i1 = 1;
         int i2 = 1;

         System.out.println(i1 == i2);

    }
}
