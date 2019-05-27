package model;

import round.Round;

import java.util.List;

public class SlotGameModel extends GameModel{

    private List<GameResult> list;
    private List<GameResult> freeRound;
    private int normalWinPercent = 30;
    private int bonusWinPercent = 10;

    public SlotGameModel() {
        list = fillPercentageList(normalWinPercent);
        freeRound = fillPercentageList(bonusWinPercent);
    }

    public int spin(Round round) {
        return calcWin(round);
    }

    public boolean wonFreeRound() {
        return freeRound.get(random(list))
                .equals(GameResult.WIN);
    }

    private int calcWin(Round round) {
        int result = -round.getRoundCost();
        int k = random(list);
        GameResult a = list.get(k);
        if (a.equals(GameResult.WIN)) {
            result += round.getRoundWin();
        }

        return result;
    }

}
