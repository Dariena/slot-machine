package model.rounds;

import round.Round;

public class BasicRound extends Round {

    private int cost = 10;
    private int win = 0;

    public int getRoundCost() {
        return cost;
    }

    public int getRoundWin() {
        return win;
    }
}
