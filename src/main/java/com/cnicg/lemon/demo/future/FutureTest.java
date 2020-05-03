package com.cnicg.lemon.demo.future;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;

import java.util.concurrent.*;


public class FutureTest {
    public static void main(String[] args) throws Exception {
//        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
//
//
//        Future future = pool.scheduleAtFixedRate(()->{
//            System.out.println("o");
//        },1,1, TimeUnit.SECONDS);
//
//        Future future2 = pool.scheduleAtFixedRate(()->{
//            System.out.println("k");
//        },1,1, TimeUnit.SECONDS);
//
//        TimeUnit.SECONDS.sleep(3);
//
//        future.cancel(true);
//
//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                System.out.println("a");
//            }
//        };


        ExecutorService executorService = Executors.newCachedThreadPool();

        SettableFuture<String> future = SettableFuture.create();
        SettableFuture<String> future2 = SettableFuture.create();

        Runnable lemonTask1 = new Runnable() {
            @Override
            public void run() {
//                System.out.println("我是一个task1");
                future.set("task1");
            }
        };
        Runnable lemonTask2 = new Runnable() {
            @Override
            public void run() {
//                System.out.println("我是一个task2");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                future2.set("task2");
            }
        };

        Future<?> future11 = executorService.submit(lemonTask1);
        Future<?> future12 = executorService.submit(lemonTask2);

//        TimeUnit.SECONDS.sleep(2);

        System.out.println(future2.isDone());
        try {
            Object o = future2.get(100, TimeUnit.MILLISECONDS);
            System.out.println(o);
        }catch (TimeoutException ex){
            System.out.println("error");
        }

        String result = future.get(100, TimeUnit.MILLISECONDS);
        System.out.println(result);

//        Futures.whenAllSucceed(future, future2).call(()->{
//            System.out.println(future.get());
//            System.out.println(future2.get());
//            return null;
//        }, executorService);

        System.out.println("end");



        CompletionService service = new ExecutorCompletionService(executorService);







//        executorService.shutdown();
    }










}
