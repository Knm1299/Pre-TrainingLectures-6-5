package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  More Threads
 * 
 *  Problems encountered when using threads
 * 
 *  Race condition
 *      - This occurs when two threads attempt to access the same resource
 *      - a thread may be already in the process of changing a resource by the time we are reading it with a different thread
 *      - This would mean that the value read is inaccurate
 *  
 *  How do we avoid Race Conditions?
 *      - Mostly, by making things synchronized and utilizing the locks
 * 
 *  Synchronized
 *      - This is a keyword that marks a method or code block 'thread safe' by introducing locks
 *      - A lock is the term for how a particular resource is bound to a thread
 *      - A thread that accesses a synchronized resource 'locks' it,
 *      - No other threads can access it while the resource is locked
 *      - Most Collections have synchronized/thread safe and unsynchronized/non-thread-safe versions
 *          - Vector is the thread safe version of ArrayList
 *          - Collections also provides wrapper classes to provide a synchronized version of an otherwise unsynchronized collection like ArrayList, see Collections.synchronizedCollection()
 * 
 *  Other issues with concurrency
 * 
 *      Deadlock
 *          - Two or more threads, two or more resources
 *          - both start, and acquire one of the resources each
 *          - one of them needs both resources, but the other thread has a lock on it
 *          - This is referred to as deadlock, as neither will release their lock, resulting in nothing ever happening, both perpetually waiting
 *      
 *      Livelock
 *          - Similar idea to deadlock, but in this case:
 *          - two or more threads
 *              - one adds to a resource when it becomes empty
 *              - the other removes from the resource when it becomes not empty
 *          - this results in the threads adding and removing cyclically
 *          - This is referred to as livelock, as both are perpetually either adding or removing
 *  
 *      The Producer-Consumer problem
 *          - One thread produces items to add to a collection when it is not full
 *          - The other thread consumes items from it when it is not empty
 *          - The problem is: how do we communicate from one to another the state of the collection
 *              Without causing deadlock or livelock?
 *          The solution: wait() and notify()
 * 
 */
public class Main {
    static List<String> moreCats;//will use later
    static int maxSize;

    static String[] catList = {"Lilo", "Cooper", "PJ", "Monet", "Jinx", "Gabby"};
    public static void main(String[] args) {

        //Regular, unsynchronized arraylist with one item
        ArrayList<String> cats = new ArrayList<>();
        cats.add("Lilo");

        //Here's our run method, checks if the ArrayList is empty, if so adds a cat, if not, removes the element at index 0
        Runnable raceCon = ()->{
            if(cats.size() > 0){
                System.out.println(cats.remove(0));
            }else{
                cats.add(catList[(int)(Math.random()*6)]);
            }
        };


        //This creates two threads for each loop and starts them one after another
        for(int i = 0; i<0; i++){
            Thread t1 = new Thread(raceCon);
            Thread t2 = new Thread(raceCon);
            
            t1.start();

            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            t2.start();

            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        //Producer-Consumer problem

        moreCats = Collections.synchronizedList(cats);
        maxSize = 6;

        Runnable produce = ()->{
            while(true){
                if(moreCats.size() < maxSize){
                    moreCats.add(catList[(int)(Math.random()*6)]);
                }
            }
        };

        Runnable consume = ()->{
            while(true){
                if(!moreCats.isEmpty()){
                    moreCats.remove(moreCats.size() - 1);
                }
            }
        };
        
        
        Main test = new Main();
        for(int i = 0; i<40000; i++){
            Thread t1 = new Thread(test::produce);
            Thread t2 = new Thread(test::consume);
            
            t1.start();

            t2.start();
        }//TODO: make these threads play nice


    }

    public synchronized void consume(){
        while(moreCats.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(moreCats.remove(moreCats.size() - 1));
        notify();
    }

    public synchronized void produce(){
        while(moreCats.size() >= maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        moreCats.add(catList[(int)(Math.random()*6)]);
        notify();
        
    }
}