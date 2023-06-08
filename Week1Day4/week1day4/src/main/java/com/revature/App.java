package com.revature;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *  Today's topics:
 *      Arrays + enhanced for loops
 *      Stacktraces, reading a stacktrace
 *      Using IDE debuggers
 * 
 *      What is an Array?
 *          Sequential block of memory
 *          if we know how many and what type of variables we're storing, we can store them all in the same block of memory
 *          int[] intArr = new int[]{1,2,3,4}
 * 
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
         * Exercise:
         *  coffee shop
         *      Create an array of different coffe types, and print these to the user as a menu
         *      While the user chooses not to exit the application:
         *          Ask the user to select a type of coffee, 
         *          take input,
         *          add the associated price to the total 
         *          Prompt the user with another menu
         *      Display the total price to the user
         */

        System.out.println("Welcome to the Pre-Training coffee shop!");

        double total = 0.0;
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        String[] coffeeMenu = new String[4];

        int[] intArr;//null
        intArr = new int[5];//{0,0,0,0,0}
        
        //using index
        coffeeMenu[0] = "Mocha";
        coffeeMenu[1] = "Espresso";
        coffeeMenu[2] = "Latte";
        coffeeMenu[3] = "Americano";

        try{
            coffeeMenu[4] = "Cappuccino";
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("There are only 4 coffees on the menu!");
        }

        while(isRunning){
            //promting the user
            System.out.println("Please select an option: ");
            
            //printing all options
            for(int i = 0; i < coffeeMenu.length; i++){
                System.out.println(i + ") " + coffeeMenu[i]);
            }
            System.out.println("Or any other number to quit");

            int input = 0;

            try{
                input = sc.nextInt();

                System.out.println("You selected: " + coffeeMenu[input]);

            }catch(ArrayIndexOutOfBoundsException e){
                
                //This is where we decide that the user selected to quit
                isRunning = false;
                continue;

            }catch(InputMismatchException e){
                System.out.println("Please enter a number");
                System.out.println("You entered: " + sc.nextLine());
            }
        }
        System.out.println("Thanks for using our coffee menu!");
    }
}
