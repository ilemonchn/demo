package com.cnicg.lemon.demo.abknowledge.reflect;

public class MyWriteProxy$appendPrefix extends MyWriteCls {

    private MyWriteCls writeCls = new MyWriteCls();

    public String appendPrefix(String param) {
//        String param = (String) params[0];
        return writeCls.appendPrefix(param);
    }





}
