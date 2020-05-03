package com.cnicg.lemon.demo.suanfa.link;

public class Node {
    public Node next;
    public String name;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
