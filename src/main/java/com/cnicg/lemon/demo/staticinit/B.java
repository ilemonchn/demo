package com.cnicg.lemon.demo.staticinit;

import java.util.concurrent.TimeUnit;

public class B {
    public static int i = 1;
    public static A a = new A();
    static {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int j = A.i;
        i = 3;
    }
}
