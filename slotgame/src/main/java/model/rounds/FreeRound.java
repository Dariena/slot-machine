package model.rounds;

import round.Round;

public class FreeRound extends Round {

    private int cost = 0;
    private int win = 20;

    public int getRoundCost() {
        return cost;
    }

    public int getRoundWin() {
        return win;
    }
}
