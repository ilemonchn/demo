package com.cnicg.lemon.demo.abknowledge;

import com.cnicg.lemon.demo.abknowledge.reflect.MyWriteCls;
import com.cnicg.lemon.demo.abknowledge.reflect.Router;

public class ABMain {

    public static void main(String[] args) throws Exception{
        String methodName = "appendPrefix";
        String[] params = new String[]{"lemon"};
        String target = "com.cnicg.lemon.demo.abknowledge.reflect.MyWriteCls";
        Class cls = Class.forName(target);

        System.out.println(Router.request(target,methodName, params));
        methodName = "appendTail";
        System.out.println(Router.request(target,methodName, params));

    }





}
