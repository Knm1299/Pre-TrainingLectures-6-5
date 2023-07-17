package com.revature;

public class GenericStack<E>{

    //A LinkedList contains Nodes
    int size = 0;
    CustomNode<E> head;
    
    public GenericStack() {
    }

    public GenericStack(E element) {
        this.head = new CustomNode<E>(element);
    }

    public void push(E element){
        this.head = new CustomNode<E>(element, this.head);
        size++;
    }

    public E pop(){
        if(isEmpty()){
            return null;
        }

        //get the element from the head of the list
        E element = this.head.contents;

        //set up the new head
        this.head = this.head.nextNode;

        size--;

        return element;
    }

    public boolean isEmpty(){
        if(size <= 0 ){
            return true;
        }else{
            return false;
        }

        // return (size <= 0) ? true : false;
    }
    
}
