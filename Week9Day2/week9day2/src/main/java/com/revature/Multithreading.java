package com.revature;

class MultithreadingDemo extends Thread {

    public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println(
                "Thread " + Thread.currentThread().getId()
                + " is running");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }

    public void hello(){
        System.out.println("Hello from within a thread!");
    }
}
