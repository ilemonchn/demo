package com.cnicg.lemon.demo.function;

import java.util.function.Function;

public class NameBuilder<T, R> {
    private final Function<T, R> core;
    public static <T,R> NameBuilder buildFA(Function<T, R> function){
        return new NameBuilder(function);
    }
    private NameBuilder(Function<T, R> function){
        this.core = function;
    }
    public R getName(T name){
        return core.apply(name);
    }
}
