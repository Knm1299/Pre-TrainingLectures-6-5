package com.revature;

/**
 * Threads
 * 
 *  Disclaimer - lots more depth here than we will cover
 * 
 *  Threads require us to discuss how code is executed.
 *  How is code executed?
 *  
 *  Ultimately, code is executed sequentially, 'in order'
 *  This works for a single application at a time, but what if we want to run more than one application/task?
 *  
 *  The answer provided for this common problem in Java is Threads
 *  
 *  Threads are a way that we can execute tasks 'asynchronously'
 *      - Essentially we can run two or more tasks at the same time*
 *          - This can allow us to make use of multi-core cpus 
 *          - Even in single core applications, threads can help utilize time spent waiting
 *
 *  Threads in Java are represented with the Thread class and the Runnable interface
 *      - Every bit of our code will run in a thread
 *      - Each of these threads has their own callstack, but shares the same heap
 *      - Each also has a 'state' in it's lifecycle
 *          - New           - not yet started
 *          - Runnable      - started, could be running
 *          - Blocked       - waiting on another thread to access a resource
 *          - Waiting       - waiting for a signal to continue running
 *          - Timed Waiting - waiting on a timer to finish to continue running
 *          - Terminated    - exit has occurred, either successfully or with an error
 * 
 */
public class App {
    public static void main( String[] args ){
        //gets the current thread
        // Thread currentThread = Thread.currentThread();

        // System.out.println(currentThread.getState());

        // Thread hello = new Thread(()->{System.out.println("Hello World!");});
        // hello.start();
        // hello();

        // // hello.stop();

        // Thread newThread = new Thread();
        // newThread.start();
        
        
        int n = 8; // Number of threads
        for (int i = 0; i < n; i++) {
            MultithreadingDemo object
                = new MultithreadingDemo();
            object.start();
        }
        


    }

    public static void hello(){
        System.out.println("Hello World! ... from a method!");
    }
}