package com.revature;

import java.io.OutputStream;
import java.util.*;

/**
 *  Exercise based lecture today
 * 
 *  Task: fill a todo list, conditionally downcast and perform behavior based on class, illustrate wrapper classes
 * 
 *  Collections: List
 *      Today, we're using ArrayList to store Objects
 *      A few notes on collections:
 *          Collections are pre-built implementations of data structures that are commonly used outside of Java
 *          Collections can only store Objects**
 *              To make Objects from primitive types, we can use wrapper classes
 *              Wrapper classes are generally named the same as primitive types, but with capital letters
 *              Java can automatically turn primitives into Objects(autoboxing) or vice versa(autounboxing)
 */
public class App {
    public static void main( String[] args ){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        arrayListExample();

        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void arrayListExample(){

        ArrayList<String> stringList = new ArrayList<>();

        System.out.println(stringList);

        stringList.add("Lilo");

        System.out.println(stringList);

        stringList.add("CANNOLI");
        stringList.add("Della");
        stringList.add("Milo");
        stringList.addAll(List.of("zuko", "Dora", "cheese"));

        System.out.println(stringList);

        System.out.println(stringList.get(0));

        System.out.println(stringList.contains("Gabby"));

        // System.out.println(stringList.remove("Lilo"));
        System.out.println(stringList.remove(0));

        System.out.println(stringList);

        //.size() - collections, .length() - Strings, .length - arrays

        for(int i = 0; i < stringList.size(); i++){
            System.out.println(stringList.get(i));
        }

        // for(String s : stringList){
        //     System.out.println(s);
        // }

        // System.out.println(stringList.isEmpty());
        // while(stringList.isEmpty() == false){
        //     System.out.println(stringList.remove(0));
        // }

    }

    /**
     * Main method modularized
     */
    public static void run(){
        //Scanner to get input
        Scanner sc = new Scanner(System.in);

        //ArrayList to store our stuff
        ArrayList<Object> todoItems = new ArrayList<>();
        //ArrayList - resizeable hybrid betweeen a linkedlist and an array

        boolean isRunning = true;

        System.out.println("Hello and welcome to the TODO list!");

        while(isRunning){
            System.out.println("Please select an option from the menu: ");
            System.out.println(
                "1) add item\n"+
                "2) remove item\n" +
                "3) view list\n"+
                "Any other input will quit"
            );

            int input= sc.nextInt();//what could go wrong here?

            switch(input){
                case 1:{
                    //Add item to arraylist

                    break;
                }
                case 2:{
                    //remove an item by id

                    break;
                }
                case 3:{
                    //view all items, also print ids since option 2 uses them, print a note if the todo is a character

                    break;
                }
                default:{
                    isRunning = false;
                }
            }
        }
    }
}
