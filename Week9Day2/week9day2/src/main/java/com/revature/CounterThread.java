package com.revature;

public class CounterThread extends Thread{

    int counter =0;

    @Override
    public void run() {
        for(; true; counter++){
            if(counter > 100_000_000){
                System.out.println("");
                stop();
            }
        }
    }
    
}
