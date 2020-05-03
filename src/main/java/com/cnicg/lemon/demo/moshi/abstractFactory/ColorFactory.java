package com.cnicg.lemon.demo.moshi.abstractFactory;

public class ColorFactory extends AbstractFactory {
    @Override
    Shape getShape(String shape) {
        return null;
    }

    @Override
    Color getColor(String color) {
        if (color.equals("red")) {
            return new Color() {
                @Override
                public void fill() {
                    System.out.println("RED");
                }
            };
        }
        return null;
    }
}
