package com.cnicg.lemon.demo.moshi.observermoshi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObserverMain {
    public static void main(String[] args) {
        NumObserver observer1 = new DigitObserver();
        NumObserver observer2 = new GraphObserver();

        NumberGenerator generator = new RandomNumGenerator();
        generator.addListenser(observer1);
        generator.addListenser(observer2);

        generator.execute();



    }
}
