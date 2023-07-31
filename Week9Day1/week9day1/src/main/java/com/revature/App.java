package com.revature;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Today's topics: 
 * 
 *  Optionals and Streams make heavy use of Lambdas and functional programming
 *       - Functional Programming means using functions to solve problems
 *          - as opposed to the typical "everytihng is an object" of Java, this means everything is a function
 * 
 *       - Functional Programming is "Declarative" rather than "Imperative"
 *          - Declarative: What do we want our code to give us as a result?
 *          - Imperative: What does my code need to do to get a result?
 * 
 *  Optionals
 *      - Alternate approach for handling nullable objects in Java 
 *      - Uses include:
 *          - specific style for approaching null checks with isPresent and ifPresent
 *          - default values can be declared where you are using the optional with orElseGet
 *      - Essentially just a different way of handling values that could be null
 *      - Uses lambdas and method reference syntax in places
 *      - Don't use for fields, use for return types
 *          - Optionals are meant for situations in which you don't want the return of a method to be null
 *          - Using them as fields can be problematic since they wrap a value
 *              - see note in main
 * 
 * 
 *  Streams
 *      - This is a functional way to approach operations on data structures
 *      - Essentially just a different approach to performing operations
 *          - Declarative vs imperative
 *              - Writing what output you want rather than the steps needed to get there
 *      - Formed with Intermediate and Terminal operations
 *          - Intermediate means an operation is occurring
 *              - Examples include map, flatmap, filter, etc.
 *          - Terminal means the stream is ending, usually with a collector
 *      - Heavy use of Lambdas and functional programming
 * 
 * 
 *  Reflections
 *      - Runtime modification of Java code
 *      - Reflections is used heavily in most frameworks
 *          - spring, Junit, etc.
 *      - We can modify our classes on the fly as our program is running
 * 
 * 
 */
public class App {
    public static void main( String[] args ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        // //Optional Example
        // String name = "Keven";

        // Optional<String> wrappedName = Optional.ofNullable(name);

        // //Not equivalent values since the Optional wraps the name object
        // System.out.println(wrappedName.equals(name));
        // //to make them .equal one another, we can get the value from the optional
        // System.out.println(wrappedName.get().equals(name));


        // System.out.println(echo(name));
        // System.out.println(echoLength(name));

        List<Integer> ints = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));

        //streams are most useful as abbreviated for-each loops

        ints = ints.stream().map(a -> a + 1).collect(Collectors.toList());
        
        // ints.stream().forEach(a -> {a = a+1; System.out.println(a);});
        ints.stream().forEach(a -> System.out.println(a));

        // System.out.println(ints);

        //FlatMap example - what if we have a list of lists?
        // List<List<Integer>> multiList = new ArrayList(List.of(ints));

        // List<Integer> multiListFlattened = multiList.stream().flatMap(a -> a.stream()).collect(Collectors.toList());

        // multiListFlattened.forEach(a -> System.out.println(a));

        // multiList.stream().forEach(a -> System.out.println(a));


        Cat monet = new Cat();
        Class catClass = monet.getClass();
        Field nameField = catClass.getDeclaredField("name");
        // monet.name = "monet";
        nameField.setAccessible(true);
        nameField.set(monet, "Monet");

        System.out.println(nameField.get(monet));
        
    }

    public static String echo(String input){
        return input;
    }

    public static int echoLength(String input){
        Optional<String> iOptional = Optional.ofNullable(input);
        return iOptional.orElse("").length();
    }
}
