package com.cnicg.lemon.demo.exception;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestEx {
    public static void main(String[] args) {


        Lemon l = (Lemon) Proxy.newProxyInstance(TestEx.class.getClassLoader(), new Class[]{Lemon.class}, new LemonInvoke());
        int ret = l.myLemon(1);
        System.out.println(ret);

        List<Long> a = new ArrayList<>();
        a.stream().collect(Collectors.toMap(c -> c, c -> c));

    }


}
