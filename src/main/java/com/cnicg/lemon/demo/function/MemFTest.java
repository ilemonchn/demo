package com.cnicg.lemon.demo.function;

public class MemFTest {
    public static void main(String[] args) {
        NameGen mygen = new NameGen("today");
        NameBuilder<String, String> builder = NameBuilder.buildFA(mygen::processName);
        System.out.println(builder.getName("haha"));

    }
}
