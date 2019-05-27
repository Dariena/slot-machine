package model.rounds;

import round.Round;

public class BonusRound extends Round {

    private int cost = 0;

    private int win = 5;

    public int getRoundCost() {
        return cost;
    }

    public int getRoundWin() {
        return win;
    }

}
