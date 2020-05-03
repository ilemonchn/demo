package com.cnicg.lemon.demo.moshi.strategymoshi;

import java.time.LocalDateTime;

public class RandomStrategy implements HandStrategy {


    @Override
    public Hand nextHand() {
        return Hand.HANDS[LocalDateTime.now().getSecond()%3];
    }

    @Override
    public void study(boolean win) {
    }
}
