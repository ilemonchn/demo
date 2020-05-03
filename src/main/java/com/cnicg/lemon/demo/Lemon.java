package com.cnicg.lemon.demo;

public class Lemon {
    private String name;

    public Lemon(){}

    public Lemon (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lemon{" +
                "name='" + name + '\'' +
                '}';
    }
}
