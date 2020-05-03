package com.cnicg.lemon.demo.queue;

public class MyProducer implements Runnable {
    private final MyQueue queue;
    private final int id;

    public MyProducer(MyQueue queue, int id){
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            String str = "content"+id+"content";
            queue.put(str);
            System.out.println("P"+id+":"+str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
