package com.cnicg.lemon.demo.abknowledge.reflect;

public class MyWriteCls {

    public String appendPrefix(String name){
        return "###" + name;
    }

    public String appendTail(String name) {
        return name + "###";
    }
}
