package com.revature;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.dao.TodoItemDAO;
import com.revature.dao.TodoItemDAOArrayListImpl;
import com.revature.dao.TodoItemDAOImpl;
import com.revature.models.TodoItem;

import com.revature.utils.*;

/**
 * DAO layer, connection factory
 * 
 *  Today we will be building out the DAO layer for our todo_item table.
 *      
 */
public class App 
{
    public static void main( String[] args )
    {
        //UI if I have time before lecture

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the TODO app!");

        //Accessing the DAO directly like this is unusual, all of this will eventually be refactored into a 'service' layer, for our business logic
        TodoItemDAO dao = new TodoItemDAOImpl();//TODO: use our implementation

        boolean running = true;
        while(running){
            System.out.println("Please select an option: ");
            System.out.println(
                "1) add a new item\n"+
                "2) find an item by id\n" +
                "3) update an item\n" +
                "4) delete an item by id\n" +
                "Any other number to quit"
            );
            int input;
            try{
                input = sc.nextInt();
                sc.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Please enter a number");
                continue;
            }

            switch(input){
                case 1:{
                    System.out.println("Enter the task: ");
                    String contents = sc.nextLine();
                    TodoItem item = new TodoItem(contents);

                    //updating the item
                    item = dao.insertNewItem(item);

                    System.out.println("Item added: ");
                    System.out.println(item);
                    break;
                }
                case 2:{
                    System.out.println("Enter the id: ");
                    int id = sc.nextInt();

                    TodoItem item = dao.getItemByID(id);

                    System.out.println("Result: ");
                    System.out.println(item);
                    break;
                }
                case 3:{
                    System.out.println("Enter the id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the task: ");
                    String contents = sc.nextLine();
                    TodoItem item = new TodoItem(id, contents);

                    //updating the item
                    item = dao.updateItem(item);

                    System.out.println("Item updated: ");
                    System.out.println(item);
                    break;
                }
                case 4:{
                    System.out.println("Enter the id: ");
                    int id = sc.nextInt();

                    boolean success = dao.deleteItemByID(id);

                    System.out.println("Deleted: ");
                    System.out.println(success);
                    break;
                }
                default:{
                    running = false;
                }
            }

        }
        System.out.println("Thanks for using the todo app!");

        sc.close();
    }
}
