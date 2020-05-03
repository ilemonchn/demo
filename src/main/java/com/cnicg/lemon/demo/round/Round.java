package com.cnicg.lemon.demo.round;

public class Round {
    public static void main(String[] args) {
        Double d = 2.1232414D;

        System.out.println((double) Math.round(d*100)/100);
        System.out.println(String.format("%.2f",d));  //系统Locale为德语是小数点会变成",";

        Integer i = 1234543;
        System.out.println(byteToMStr(i));

    }

    public static String byteToMStr(Integer byteSize){
        double m = Double.valueOf(byteSize) / 1024 / 1024;
        return String.valueOf(((double) Math.round(m*100))/100);
    }
}
