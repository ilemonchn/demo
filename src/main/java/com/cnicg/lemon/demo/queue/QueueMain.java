package com.cnicg.lemon.demo.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class QueueMain {

    private static ExecutorService PEXE = Executors.newFixedThreadPool(5);
    private static ExecutorService CEXE = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        MyQueue queue = new MyQueue();
        PEXE.execute(new MyProducer(queue, 1));
        PEXE.execute(new MyProducer(queue, 2));
        PEXE.execute(new MyProducer(queue, 3));
        PEXE.execute(new MyProducer(queue, 4));
        PEXE.execute(new MyProducer(queue, 5));

        TimeUnit.SECONDS.sleep(1);

        CEXE.execute(new MyConsumer(queue, 6));
        CEXE.execute(new MyConsumer(queue, 7));
        CEXE.execute(new MyConsumer(queue, 8));
        CEXE.execute(new MyConsumer(queue, 9));
        CEXE.execute(new MyConsumer(queue, 10));

        System.out.println("END");
    }
}
