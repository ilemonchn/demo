package com.cnicg.lemon.demo.abknowledge.reflect;

import java.util.HashMap;
import java.util.Map;

public class Router {
    private static Map<String, Object> proxyMap = new HashMap<>();
    private static Map<String, Integer> proxyInt = new HashMap<>();

    static {
        proxyMap.put("com.cnicg.lemon.demo.abknowledge.reflect.MyWriteCls", new MyWriteCls());
        proxyInt.put("appendPrefix", 0);
        proxyInt.put("appendTail", 1);
    }

    public static Object getObject(String methodName) {
        return proxyMap.get(methodName);
    }

    public static Object request(String target, String methodName, Object... params) throws Exception {
        int i = proxyInt.get(methodName);
        switch (i) {
            case 0:{
                String param = (String) params[0];
                return ((com.cnicg.lemon.demo.abknowledge.reflect.MyWriteCls)getObject(target)).appendPrefix(param);
            }
            case 1:{
                String param = (String) params[0];
                return ((com.cnicg.lemon.demo.abknowledge.reflect.MyWriteCls)getObject(target)).appendTail(param);
            }
            default:{
                throw new RuntimeException("method not found!");
            }
        }
    }
}
