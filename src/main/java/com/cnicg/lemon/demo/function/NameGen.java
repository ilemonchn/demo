package com.cnicg.lemon.demo.function;


public class NameGen implements MyProcess {
    private String prefix;

    public NameGen(String prefix){
        this.prefix = prefix;
    }

    public String processName(String name){
        return prefix + name;
    }

}
