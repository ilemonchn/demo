package com.cnicg.lemon.demo.random;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyRandom {
    public static List<Integer> list = Lists.newArrayList(1,2,3,4,5);

    public static void main(String[] args) {

        Collections.shuffle(list);
//        System.out.println(list.get(0));

//        System.out.println(System.currentTimeMillis()/1000);
//        List<Integer> l = new ArrayList<>();
//        l.forEach( a -> {
//            System.out.println("aaa");
//        });



    }





}
