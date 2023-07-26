package com.revature;

public class AnimalFactory {
    static Animal getAnimal(String foodType){
        if(foodType.equals("kibble")){
            return new Dog();
        }else{
            return new Panda();
        }
    }
}
