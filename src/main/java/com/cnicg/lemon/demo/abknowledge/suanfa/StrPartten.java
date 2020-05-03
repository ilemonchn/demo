package com.cnicg.lemon.demo.abknowledge.suanfa;

import java.util.HashMap;
import java.util.Map;

public class StrPartten {
    public static void main(String[] args) {
        String a = "ab";
        String b = "cd";
        System.out.println(transfor(a).equals(transfor(b)));

    }


    private static String transfor(String a) {
        char[] chars = a.toCharArray();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int index = 1;
        for (char c: chars) {
            if (map.get(c) == null) {
                map.put(c, index);
                index++;
            }
            sb.append(map.get(c));
        }
        return sb.toString();
    }
}
