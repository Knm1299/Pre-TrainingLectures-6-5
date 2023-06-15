package com.revature;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


/**
 * Exceptions
 * 
 *  Exceptions are objects that represent an interruption in the normal operation of your code.
 *  
 *  Exceptions are NOT errors, though they are similar
 *      Errors typically refer to a larger situation regarding the machine which should not be recovered from
 *      Exceptions can generally be recovered from with proper handling
 * 
 *  Exceptions are broken down into two categories:
 *      Checked(Compile time exceptions)
 *          These are checked at compile time
 *              Java will not allow our program to compile if something that could throw one of these is present
 *          
 * 
 *      Unchecked(Runtime Exceptions)
 *          Runtime Exceptions extent the RuntimeException class
 *          And they don't need to be handled in order to compile
 *              ie. java doesn't check if they're handled while compiling
 * 
 * 
 *      Either way, exceptions can all be caught with a try/catch, or a try/catch/finally
 * 
 *      throw - throws an exception, causes an exception to occur on that line
 *      throws - marks a method to say that it *could* throw an exception
 *
 */
public class App {
    public static void main( String[] args ){
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
            
            int input = 0;

            try{
                input = sc.nextInt();//what could go wrong here?
            }catch(InputMismatchException e){
                System.out.println("Enter a valid menu option!");
                e.printStackTrace();
            }catch(Exception e){
                //list the exception types from most specific to least specific
            }finally{
                System.out.println("Hello!");//will run if an exception is thrown or not
            }

            sc.nextLine();

            switch(input){
                case 1:{
                    //Add item to arraylist
                    System.out.println("Please enter the contents of the todo item: ");
                    String text = sc.nextLine();

                    if(text.length() == 1){

                        catchB(text.toUpperCase().charAt(0));
                        
                        todoItems.add((Character)text.charAt(0));

                    }else if(text.length() == 0){

                        System.out.println("No message was entered");
                        break;

                    }else{
                        todoItems.add(text);
                    }

                    break;
                }
                case 2:{
                    //remove an item by index
                    System.out.println("Enter the index you wish to remove: ");
                    
                    int id = sc.nextInt();//inputmismatch

                    if(id >= 0 && id < todoItems.size()){
                        todoItems.remove(id);
                        System.out.println("Item removed successfully");
                    }else{
                        System.out.println("Item index not found");
                    }

                    break;
                }
                case 3:{
                    //view all items, also print indexes since option 2 uses them, print a note if the todo is a character
                    System.out.println("Here are the current todo items: \n[");

                    for(int i = 0; i < todoItems.size(); i++){
                        if(todoItems.get(i) instanceof String){
                            System.out.println(i + ") " + todoItems.get(i));
                        }else if(todoItems.get(i) instanceof Character){
                            System.out.println(i + ") " + todoItems.get(i) + " (single character entry)");
                        }
                    }

                    System.out.println("]");

                    break;
                }
                default:{
                    isRunning = false;
                }
            }
        }

    }

    public static char catchB(char c) throws LetterBException{
        if(c == 'B'){
            throw new LetterBException();
        }
        return c;
    }
  
}
