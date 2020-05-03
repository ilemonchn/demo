package com.cnicg.lemon.demo.moshi.abstractFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String command) {
        if (command.equals("shape")) {
            return new ShapeFactory();
        }
        if (command.equals("color")) {
            return new ColorFactory();
        }
        return null;
    }
}
