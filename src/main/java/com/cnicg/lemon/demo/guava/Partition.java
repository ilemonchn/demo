package com.cnicg.lemon.demo.guava;

import com.google.common.collect.Lists;

import java.util.List;

public class Partition {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        for (int i=0;i<201;i++){
            list.add(i);
        }

        List<List<Integer>> partition = Lists.partition(list, 200);
        partition.stream().forEach(c -> {
            System.out.println(c.size());
        });
//        System.out.println(partition);
        long a = 60;
        int b = 60;
        System.out.println(a * 86400 * 1000);
        System.out.println(b * 86400 * 1000);


    }
}
