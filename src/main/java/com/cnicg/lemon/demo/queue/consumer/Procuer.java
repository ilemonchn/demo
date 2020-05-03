package com.cnicg.lemon.demo.queue.consumer;

import com.cnicg.lemon.demo.queue.MyQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Procuer extends Thread{

    private String name;
    private MyQueue queue;

    public Procuer(MyQueue queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {

        int i = 0;

        while (true) {
            i++;
            System.out.println(name + ":" + i);
            try {
                TimeUnit.SECONDS.sleep(1);
                queue.put(name +"-"+ i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


}
