package com.cnicg.lemon.demo.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ATest {
    private static volatile AtomicInteger total = new AtomicInteger(0);
    private static CountDownLatch latch = new CountDownLatch(20);
    private static ExecutorService service = Executors.newFixedThreadPool(20);
    public static void main(String[] args) throws InterruptedException {

        MyTask task = new MyTask(total, latch);

        for (int i= 0; i<20;i++){
            service.execute(task);
        }

        TimeUnit.SECONDS.sleep(2);

        latch.await();
        System.out.println(total);
        service.shutdown();
    }
}
