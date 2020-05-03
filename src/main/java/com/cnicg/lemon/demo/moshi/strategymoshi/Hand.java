package com.cnicg.lemon.demo.moshi.strategymoshi;

public class Hand {
    public static final int JIANDAO = 0;
    public static final int SHITOU = 1;
    public static final int BU = 2;

    public static final Hand[] HANDS = {
            new Hand(JIANDAO),
            new Hand(SHITOU),
            new Hand(BU)
    };

    private int handValue;
    public Hand(int handValue){
        this.handValue = handValue;
    }

    public int isStrongerThan(Hand another){
        if(another.handValue == this.handValue){
            return 0;
        }

        if(another.handValue - this.handValue == 1 ||
            another.handValue - this.handValue == -2
        ){
            return -1;
        }

        return 1;
    }


}
