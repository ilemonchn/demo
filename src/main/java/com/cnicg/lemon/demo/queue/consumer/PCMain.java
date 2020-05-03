package com.cnicg.lemon.demo.queue.consumer;

import com.cnicg.lemon.demo.queue.MyQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class PCMain {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        Procuer p1 = new Procuer(queue, "P1");
        Procuer p2 = new Procuer(queue, "P2");
        Procuer p3 = new Procuer(queue, "P3");
//        Procuer p4 = new Procuer(queue, "P4");
//        Procuer p5 = new Procuer(queue, "P5");
        p1.start();
        p2.start();
        p3.start();

        Consumer c1 = new Consumer(queue, "C1");
        Consumer c2 = new Consumer(queue, "C2");
        Consumer c3 = new Consumer(queue, "C3");
        Consumer c4 = new Consumer(queue, "C4");

        c1.start();
        c2.start();
        c3.start();
        c4.start();



    }



}
