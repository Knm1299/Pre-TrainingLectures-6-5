package com.revature;

import java.util.*;

import io.javalin.Javalin;
import io.javalin.http.Context;

/**
 *  Today's topics: Functional interfaces, method references, lambdas, anonymous methods/classes
 * 
 *  What is a functional Interface?
 *      An interface with a single method
 *      Since the interface has only a single method, java gives us a couple options for simplifying it's impelmentation.
 *      These options are:
 * 
 *      Method Reference
 *          using class::method syntax, we can refer to a method without actually calling it. 
 *          This means that if a method requires a functional interface as a parameter, 
 *              we can pass a method reference in that refers to a pre-existing method, 
 *              thereby fulfilling the functional interface's requirement
 *          This approach has simple syntax, but still allows for modular design.
 *          
 *          Syntax: Class::Method
 *              No parameters required, since they're defined by the functional interface
 * 
 *      Lambda functions
 *          Lambda functions, also called anonymous methods, are methods that are implemented inline. 
 *          Rather than being written elsewhere, and then called when needed, these are written right where they are needed.
 *          This makes simple operations like comparisons very easy, but for more complex operations can get obtuse quickly
 *      
 *          Syntax: (parameters, can be ClassName variableName or just variableName) -> {implementation, if single statement then curly braces can be ignored}
 *          
 *              ex. 
 *              (String str) -> {System.out.println(str);};
 *              (str) -> {System.out.println(str);};
 *              str -> {System.out.println(str);};
 *              str -> System.out.println(str);
 *              
 *              All 4 of these are functionally identical, each return a void
 * 
 */
public class App 
{
    public static void main( String[] args )
    {
        //tiny little Javalin example, we will actually start using this tomorrow
        //if following along, make sure you get the dependencies from the pom.xml
        Javalin app = Javalin.create();
        app.get("/hello", App::sayHello);
        app.get("/lambda", ctx -> ctx.json("Hello, World!"));
        app.start();

        //This is implementing an interface anonymously
        twoMethodInterface anonymousImpl = new twoMethodInterface() {
            public void method1(){
                return;
            }
            public void method2(){
                return;
            }
        };

        //implementation provided right here, only useable via this Object
        ExampleFunctionalInterface lambdaSyntax = (str) -> {System.out.println(str);};

        //this implementation required a class to provide it, then needed the class to be instantiated
        ExInterfaceImpl implementedInterface = new ExInterfaceImpl();

        //Method reference syntax is a happy medium, not so much code, but readable and reusable
        ExampleFunctionalInterface referenceSyntax = App::exampleMethod;

        //invoking each method, they all work the same
        lambdaSyntax.printSomething("Some string");
        
        implementedInterface.printSomething("Hello!");

        referenceSyntax.printSomething("World!");

        //example of comparator using an ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(List.of(1,2,3,4));
        //to sort a collection: for each element, determine if it is larger than the next element
        list.sort(App::compareTwoInts);
        
    }

    //implemented with method reference, easier to see what it does, and now reusable elsewhere
    static int compareTwoInts(Integer a, Integer b){
        if(a > b){
            return 1;
        }else if (a < b){
            return -1;
        }else{
            return 0;
        }
    }

    static void exampleMethod(String str){
        System.out.println(str);
    }


    //used for the javalin application, rather than being written inline
    public static void sayHello(Context ctx){
        ctx.json("Hello, World!");
    }

}
