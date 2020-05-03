package com.cnicg.lemon.demo.abknowledge.threadlocal;

import com.cnicg.lemon.demo.untitle.TestMain;

public class LemonRunDecor {


    public Runnable decorate(Runnable runnable) {
        String str = TestLocal.testLocal.get();

        return () -> {
            TestLocal.testLocal.set(str);
            runnable.run();
        };

    }



}
