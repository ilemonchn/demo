package com.cnicg.lemon.demo.moshi.CommandMoshi.order;

public class PrintNameOrder implements Order {


    private String name;

    public PrintNameOrder(String name){
        this.name = name;
    }

    public void printName(){
        System.out.println("qianzui:" + name);
    }


    @Override
    public void excute() {
        printName();
    }
}
