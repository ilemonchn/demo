package com.cnicg.lemon.demo.moshi.observermoshi;

public class DigitObserver implements NumObserver {
    @Override
    public void onNumUpdate(NumberGenerator generator) {
        System.out.println("num is " + generator.getNum());
    }
}
