package com.cnicg.lemon.demo;

import com.cnicg.lemon.demo.future.Singal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//@RunWith(JUnit4.class)
public class TestVolate {

    private static final ExecutorService pool = Executors.newCachedThreadPool();
    private static Singal count = new Singal();

    private static final Logger LOGGER = LoggerFactory.getLogger(TestVolate.class);

//    @Test
//    public void testVolate() throws Exception{
//        System.out.println("a");
//
//
//        pool.execute(()->{
//            try {
//                TimeUnit.SECONDS.sleep(3);
//                count.setCount(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//
//        while (true){
//            if(count.getCount()==1){
//                break;
//            }
//        }
//
//        System.out.println("b");
//        Assert.assertTrue("a".equals("a"));
//    }

    @Test
    public void testB(){
        System.out.println("B");
        Assert.assertTrue(1==1);
    }

    @Test
    public void testC(){
        Integer j = 21;
        List<Integer> list= null;
//        list.add(j);
        System.out.println(list);
        LOGGER.info("error:{}",list);
    }



}
