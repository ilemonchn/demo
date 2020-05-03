package com.cnicg.lemon.demo.poolGracefullyShutdown;

import org.springframework.beans.factory.DisposableBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutDownPool implements DisposableBean {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        //方式一 (kill -15)
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                //不再接收新task
                executorService.shutdown();
                try {
                    //等待30s关服
                    executorService.awaitTermination(30, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void destroy() throws Exception {
            //方式二，这里处理关闭；
    }
}
