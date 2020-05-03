package com.cnicg.lemon.demo.moshi.abstractFactory;

public class ShapeFactory extends AbstractFactory {
    @Override
    Shape getShape(String shape) {
        if (shape.equals("red")) {
            return new Shape() {
                @Override
                public void drew() {
                    System.out.println("RED");
                }
            };
        }
        return null;
    }

    @Override
    Color getColor(String color) {
        return null;
    }
}
