package com.cnicg.lemon.demo.moshi.observermoshi;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberGenerator {
    private int num;
    private List<NumObserver> observers = new ArrayList<>();

    public void addListenser(NumObserver observer){
        this.observers.add(observer);
    }

    public void execute(){
        updateNum();
        observers.forEach(e -> {
            e.onNumUpdate(this);
        });
    }

    public int getNum(){
        return num;
    }

    public void setNum(int num){
        this.num = num;
    }

    public abstract void updateNum();

}
