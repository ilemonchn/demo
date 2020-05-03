package com.cnicg.lemon.demo.moshi.CommandMoshi.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderRunner implements Order{

    private List<Order> orders = new ArrayList<>();


    public void pushOrder(Order order){
        if(order != this)
        orders.add(order);
    }

    @Override
    public void excute() {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()){
            iterator.next().excute();
        }
    }
}
