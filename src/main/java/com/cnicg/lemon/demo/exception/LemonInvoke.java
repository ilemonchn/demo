package com.cnicg.lemon.demo.exception;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LemonInvoke implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int a  = (int) args[0];
        if(a == 1){
            throw new Exception("myEx");
        }
        Lemon l = new LemonImpl();
        Object ret = method.invoke(l, args);

        return ret;
    }
}

