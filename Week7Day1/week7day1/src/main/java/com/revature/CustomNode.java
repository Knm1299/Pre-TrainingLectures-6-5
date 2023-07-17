package com.revature;

public class CustomNode<E> {
    E contents;
    CustomNode<E> nextNode;


    public CustomNode(E contents) {
        this.contents = contents;
    }


    public CustomNode(E contents, CustomNode<E> nextNode) {
        this.contents = contents;
        this.nextNode = nextNode;
    }

    
    
}
