package com.cnicg.lemon.demo.moshi.observermoshi;

import java.util.Random;

public class RandomNumGenerator extends NumberGenerator {
    @Override
    public void updateNum() {
        int num = new Random(47).nextInt(10);
        setNum(num);
    }
}
