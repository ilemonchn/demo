package com.cnicg.lemon.demo.moshi.strategymoshi;

public class StrategyMain {
    public static void main(String[] args) {
        Player player1 = new Player("player1",new WinningStrategy());
        Player player2 = new Player("player2",new RandomStrategy());

        int i = 3;
        while (i>0){
            Hand hand1 = player1.showNextHand();
            Hand hand2 = player2.showNextHand();

            if(hand1.isStrongerThan(hand2) == 1){
                player1.win();
                player2.loose();
                System.out.println("player1 win");
            }
            if(hand1.isStrongerThan(hand2) == -1){
                player1.loose();
                player2.win();
                System.out.println("player2 win");
            }
            if(hand1.isStrongerThan(hand2) == 0){
                player1.even();
                player2.even();
                System.out.println("even");
            }
            i--;
        }

    }
}
