package com.cnicg.lemon.demo.moshi.strategymoshi;

public class Player {
    private HandStrategy strategy;

    private String playerName;
    private int winCount=0;
    private int totalCount=0;

    public Player(String playerName,HandStrategy strategy){
        this.playerName = playerName;
        this.strategy = strategy;
    }

    public Hand showNextHand(){
        totalCount++;
        return strategy.nextHand();
    }

    public void win(){
        winCount++;
        strategy.study(true);
    }

    public void loose(){
        strategy.study(false);
    }

    public void even(){

    }
}
