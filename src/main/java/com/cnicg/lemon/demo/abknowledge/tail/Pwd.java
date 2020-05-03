package com.cnicg.lemon.demo.abknowledge.tail;

import java.util.Scanner;

public class Pwd {
    public static void main(String[] args) throws Exception {
        Process process = Runtime.getRuntime().exec("pwd");
        Scanner scanner = new Scanner(process.getInputStream());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        process.waitFor();
        System.out.println("启动成功");
    }
}
