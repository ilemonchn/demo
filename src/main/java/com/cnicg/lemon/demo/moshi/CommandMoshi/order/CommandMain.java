package com.cnicg.lemon.demo.moshi.CommandMoshi.order;

public class CommandMain {
    public static void main(String[] args) {
        Order print = new PrintNameOrder("lemon");
        OrderRunner runner = new OrderRunner();
        runner.pushOrder(print);
        runner.excute();
    }
}
