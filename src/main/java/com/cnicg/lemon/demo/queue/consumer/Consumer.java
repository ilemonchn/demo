package com.cnicg.lemon.demo.queue.consumer;

import com.cnicg.lemon.demo.queue.MyQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer extends Thread {
    private String name;
    private MyQueue queue;

    public Consumer(MyQueue queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("#######" +name+":" + queue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
