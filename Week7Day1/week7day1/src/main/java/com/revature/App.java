package com.revature;

import java.util.*;

/**
 * Today's Topic: Generics, collections, Stacks, Queues, LinkedList
 * 
 *  Generics - This is how collections work
 *             Each collection stores a specific 'type' of object
 *             We can use a type parameter to make a collection(or any class) generic
 *             This means that the type of object we are manipulating with the generic is defined where we use the generic,  
 *              rather than within the generic's class file.
 * 
 * 
 *  Example: Let's build a LinkedList from scratch //TODO
 * 
 *  LinkedList
 *      Made of nodes, each node has an object which it stores, 
 *      as well as a link to the previous, next, or both previous and next nodes
 *      Java uses a doubly linked list, so each node has links to both previous and next
 * 
 * 
 *  Stacks we have already discussed, but the largest difference between the following two is
 *      Insertion vs Retrieval order
 * 
 *  Stack
 *      Insertion order: Last In
 *      Retrieval order: First Out
 *      LIFO
 *  
 *      Can be thought of like a stack of books or pancakes, only able to interact with the top
 * 
 *  Queue
 *      Insertion order: First In
 *      Retrieval order: First Out
 *      FIFO
 * 
 *      Can be thought of like a line of people, more join from the back, and leave from the front
 *
 * 
 *  Segue into tomorrow's lecture topic: collections hierarchy
 * 
 * 
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("LinkedList Example: ");
        
        List<String> list = new LinkedList<String>();

        list.add("Hello");
        list.add("World!");

        for(String s : list){
            System.out.println(s);
        }

        System.out.println("Stack Example: ");

        Stack<String> stack = new Stack<>();
        
        stack.push("Hello");
        stack.push("World!");

        while(stack.empty() == false){
            System.out.println(stack.pop());
        }

        System.out.println("Queue Example: ");

        Queue<String> queue = new ArrayDeque<String>();

        queue.add("Hello");
        queue.add("World!");
        
        
        while(queue.isEmpty() == false){
            System.out.println(queue.poll());
        }

        System.out.println("Custom List Example: ");

        GenericStack<String> customList = new GenericStack<String>();

        customList.push("Hello");
        customList.push("World!");

        while(customList.isEmpty() == false){
            System.out.println(customList.pop());
        }

    }
}
