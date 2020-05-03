package com.cnicg.lemon.demo.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTask implements Runnable {

    private AtomicInteger count = new AtomicInteger(0);

    private AtomicInteger total;

    private CountDownLatch lanch;

    public MyTask(AtomicInteger total, CountDownLatch lanch){
        this.lanch = lanch;
        this.total = total;
    }

    @Override
    public void run() {
        lanch.countDown();
        try {
            System.out.println("count:"+lanch.getCount());
            lanch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(count.incrementAndGet() > 1){
            return;
        }
        total.incrementAndGet();
    }
}
