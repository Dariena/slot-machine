package model.rounds;

import round.Round;

public class NormalRound extends Round {

    private int cost = 10;
    private int win = 20;

    public int getRoundCost() {
        return cost;
    }

    public int getRoundWin() {
        return win;
    }
}
