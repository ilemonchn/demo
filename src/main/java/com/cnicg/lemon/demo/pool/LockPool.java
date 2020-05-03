package com.cnicg.lemon.demo.pool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LockPool {
    public static void main(String[] args) throws Exception {

        ExecutorService pool = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(1);

        pool.execute(()->{
            System.out.println("thread 1 start");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 1 end");
        });

        pool.execute(()->{
            System.out.println("thread 2 start");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 2 end");
        });

        TimeUnit.SECONDS.sleep(1);

        pool.execute(()->{
            System.out.println("thread 3 start");
            try {
                latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("thread 3 end");
        });

    }

}
