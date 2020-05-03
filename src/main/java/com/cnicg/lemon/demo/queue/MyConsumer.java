package com.cnicg.lemon.demo.queue;

public class MyConsumer implements Runnable {

    private final MyQueue queue;
    private final int id;

    public MyConsumer(MyQueue queue, int id){
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            String str = queue.take();
            System.out.println("C"+id+":"+str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
