package com.cnicg.lemon.demo.abknowledge.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLocal {
    public static ThreadLocal<String> testLocal = new InheritableThreadLocal<>();

    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws Exception{
        LemonRunDecor decor = new LemonRunDecor();
        //线程池创建2个线程，因此线程池的线程的父线程为main的主线程
        executor.submit(() -> {
            System.out.println("task0" + testLocal.get());

        });
        executor.submit(() -> {
            System.out.println("task0" + testLocal.get());

        });

        //此处thread为模拟 netty server的work线程池
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("child");
                //拦截器解析协议header放到局部变量
                testLocal.set("lemon");
                System.out.println("t" + testLocal.get());

                //此执行线程的父线程非thread，因此无法继承局部变量，需要decor装饰暂时保存局部变量
                executor.submit(decor.decorate(() -> {
                    System.out.println("task1" + testLocal.get());
                }));
                //此线程演示无法继承
                executor.submit(() -> {
                    System.out.println("task2" + testLocal.get());
                });

            }
        };

        thread.start();
        System.in.read();
    }
}
