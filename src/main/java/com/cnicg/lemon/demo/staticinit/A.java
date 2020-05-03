package com.cnicg.lemon.demo.staticinit;

import java.util.concurrent.TimeUnit;

public class A {
    public static int i = 0;
    public static B b = new B();
    static {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int j = B.i;
        i = 2;
    }
}
