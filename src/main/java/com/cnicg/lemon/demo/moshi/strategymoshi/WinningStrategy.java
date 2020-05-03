package com.cnicg.lemon.demo.moshi.strategymoshi;

import java.util.Random;

public class WinningStrategy implements HandStrategy {

    private Hand prevHand;
    private boolean win = false;
    private static Random random = new Random(47);

    @Override
    public Hand nextHand() {
        if(win){
            return prevHand;
        }
        return prevHand = Hand.HANDS[random.nextInt(3)];
    }
    @Override
    public void study(boolean win) {
        this.win = win;
    }
}
