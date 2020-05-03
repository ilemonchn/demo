package com.cnicg.lemon.demo.moshi.abstractFactory;

public class FactoryMain {
    public static void main(String[] args) {
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        colorFactory.getColor("red").fill();
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        shapeFactory.getShape("red").drew();
    }


}
