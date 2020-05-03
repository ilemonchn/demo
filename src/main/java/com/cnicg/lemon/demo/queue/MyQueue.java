package com.cnicg.lemon.demo.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue {
    private int capacity = 3;
    private String[] interArrays = new String[capacity];
    private int count = 0;
    private int indexPut = 0;
    private int indexTake = 0;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public void put(String str) throws Exception {
        lock.lock();
        try {
            while (count == capacity){
                notFull.await();
            }

            count++;
            interArrays[indexPut] = str;
            if(indexPut == (capacity - 1)){
                indexPut = 0;
            }else {
                indexPut++;
            }
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public String take() throws Exception {
        lock.lock();
        String ret;
        try {
            while (count == 0){
                notEmpty.await();
            }

            count--;
            ret = interArrays[indexTake];
            if(indexTake == (capacity - 1)){
                indexTake = 0;
            }else {
                indexTake++;
            }
            notFull.signal();
            return ret;
        }finally {
            lock.unlock();
        }
    }





}
