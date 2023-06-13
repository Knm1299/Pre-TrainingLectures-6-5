package com.revature;

/**
 * Stack, Heap, Garbage collection
 * 
 * More notes today, likely a short lecture
 * 
 * When we run a program, our OS gives the program a specific amount of RAM for it to use to store data. 
 * 
 * The RAM that a program is allocated is usually divided into two sections:
 *      1. Stack   
 *          Useful info for us:
 * 
 *          Stack has a set maximum size, and follows a strict structure.
 *          Stack is used to keep track of the variables available in the current scope
 *          only primitive datatypes can be stored on the stack, objects are stored in heap
 * 
 * ------------------------------------------------------------------------------------------
 *          Less useful, more about yesterday's discussion:
 * 
 *          Stack is used to keep track of our execution context
 *          Execution context means:
 *              Where we are in the program(what class/method/code block)
 *              What variables exist here
 *          When we enter a new method, a new 'Stack frame' is added to the stack to represent our new execution context
 *          While in an execution context, we are at the 'top' of the stack, 
 *              and have access to all the variables created in previous 'lower' execution contexts
 * 
 * ------------------------------------------------------------------------------------------
 *      2. Heap
 *          As opposed to the Stack's rigid structure and size limit, heap is variable in size and less structured.
 *          Heap is where *everything* else is stored
 *          Objects are all stored in heap, and most things we interact with in Java are objects
 * 
 * ------------------------------------------------------------------------------------------
 *  Garbage Collection:
 *      By this point, I've talked for a while about things that really don't affect anything when writing java code.
 *      The reason we don't have to worry about these things is called the garbage collector
 *      
 *      The Garbage Collector is a kind of routine that Java runs periodically.
 *      If an object exists but has no references(not stored with a variable), it will be collected(deleted)
 *      
 *      We cannot control the GC manually, though we can request it be run
 * 
 */
public class App{
    public static void main( String[] args ){
        String hello = new String("Hello World!");
        String goodbye = new String("Goodbye!");

        hello = goodbye;

        System.out.println(hello);
        System.out.println(goodbye);

        System.gc();


        //String pooling
        String s = "String";
        String t = "String";

        System.out.println(s == t);

        System.out.println(s.equals(t));

        //The string pool hold all strings created with literals

        
        //brief aside about casting
        //with primitives, only restriction is loss of precision
        double i = 100.123456;
        System.out.println((int)i);
        //with objects, some classes cannot be cast between, and downcasting always depends on underlying objects
        Object o = "String";

        System.out.println(o);

        //App u = (App)o;//cannot be done because the object itself is not an instanceof App

        //This works since o is an instance of a String
        String u = (String)o;//works
        if(o instanceof String){
            System.out.println("It's a String!");
        }
        if(o instanceof Object){
            System.out.println("It's an Object!");
        }
        // if(o instanceof App){
        //     System.out.println("It's an App!");
        // }

        // System.exit(0);
        Object p = new Object();
        System.out.println(p.toString());
        System.out.println(o.toString());
    }
}
