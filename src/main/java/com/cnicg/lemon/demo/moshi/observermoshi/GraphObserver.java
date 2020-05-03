package com.cnicg.lemon.demo.moshi.observermoshi;

public class GraphObserver implements NumObserver {
    @Override
    public void onNumUpdate(NumberGenerator generator) {
        for (int i = 0;i < generator.getNum();i++){
            System.out.print("*");
        }
        System.out.println(" graph num is " + generator.getNum());
    }
}
