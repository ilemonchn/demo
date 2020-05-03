package com.cnicg.lemon.demo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {
    public static void main(String[] args) {
        String[] strings = {"Hello", "World"};

        Stream<String[]> stream = Arrays.asList(strings).stream().map(str -> str.split(""));
        Stream<String> stream1 = stream.flatMap(obj -> Arrays.stream(obj));
        List<String> list1 = stream1.collect(Collectors.toList());


        System.out.println(list1);



    }
}
