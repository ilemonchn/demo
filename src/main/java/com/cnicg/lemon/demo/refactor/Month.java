package com.cnicg.lemon.demo.refactor;

public enum Month {

    JANUARY(31);

    private int lastDay;
    Month(int lastDay){
        this.lastDay = lastDay;
    }

    public int lastDay(){
        return lastDay;
    };
}
