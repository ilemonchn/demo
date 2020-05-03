package com.cnicg.lemon.demo.staticinit;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

public class C {
    private static Map<String, String> map = new HashMap<>();
    static {
        Executors.newCachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                map.put("2","2");
            }
        });
        Executors.newCachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                map.put("3","3");
            }
        });
        map.put("1","1");

    }


    public static void main(String[] args) {
        System.out.println(A.b.i);
        System.out.println(C.map.get("2"));

    }
}
