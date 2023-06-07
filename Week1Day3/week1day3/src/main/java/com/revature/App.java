package com.revature;

import java.util.Scanner;

/**
 * Control flow
 * 
 *  Control flow: changing the execution of a program to either branch or loop
 *      Two kinds of control flow structures:
 *          Branching:
 *              If/else statements, ternaries(will not go into detail on this in class)
 *              Switch statements
 *          Looping:
 *              While           - checks a condition before running, executes and goes back to the condition if true
 *              Do-While        - same as while, but the condition is at the end(bottom) of the loop
 *              For             - abbreviated loop for a common pattern used to iterate a certain number of times
 *              Enhanced For    - used to iterate over data structures like Arrays
 */
public class App 
{
    public static void main( String[] args )
    {
        //Scanner is used to retrieve information line by line, in this case we are getting it from the console
        Scanner sc = new Scanner(System.in);
        //ClassName variableName = new ClassName(); - standard syntax for declaring and initializing a new object

        //First, a welcome message
        System.out.println(
            "Welcome to the interest calculator!" + "\n" +
            "Please enter the information for your loan: "
        );

        //prompt the user
        System.out.println("Please enter the principal(starting amount): ");
        //getting input, assigning it to a variable
        double principal = sc.nextDouble();

        System.out.println("Please enter the number of terms: ");
        int terms = sc.nextInt();

        System.out.println("Please enter the interest rate(in percent): ");
        double rate = sc.nextDouble();

        sc.nextLine();

        //We need to apply interest to the principal for each of the terms, and return the resulting total

        //loop terms times
            //add ((rate/100) * principal) to principal
        
        while(terms > 0){
            principal += ((rate / 100) * principal);
            // principal = principal * (1 + rate/100);

            terms = terms - 1;//terms--, terms -= 1
        }
        //terms == 0
        System.out.println("loop is done, total paid: " + principal);

        // int counter = 1;
        // while(counter <= terms){
        //     System.out.println("This is iteration: " + counter);
        //     counter += 1;
        // }

        boolean keepRunning = true;
        while(keepRunning){
            System.out.println("Do you want to continue the loop? y/n: ");
            String userInput = sc.nextLine();

            //if/else
            //switch case

            // if(userInput.equalsIgnoreCase("y")){
            //     System.out.println("ok");
            //     //continue//continues the loop from the condition
            // }else if(userInput.equalsIgnoreCase("N")){
            //     System.out.println("You entered n");
            //     break;//ends the loop and continues executing
            // }else{
            //     System.out.println("something else");
            //     break;
            // }
            // System.out.println("looping again!");

            switch(userInput){
                case "y": {
                    System.out.println("ok");
                    break;
                }

                case "Y" : {
                    System.out.println("OK");
                }
                default : {
                    if(userInput.equals("N")){
                        break;
                    }
                    System.out.println("default");
                    keepRunning = false;
                    // break;
                }
            }

        }
        System.out.println("out of the loop!");
        // for(
        //     int i = 1; //declaration - establishing a counter
        //     i <= terms;//condition   - condition that we will continue to loop 'while' true
        //     i += 1     //adjustment  - some change to that counter so that the condition is eventually false
        // ){
        //     System.out.println("This is iteration: " + i);
        // }
    }
}
