package controller;

import model.SlotGameModel;
import model.rounds.FreeRound;
import model.rounds.NormalRound;
import round.Round;
import statistic.Statistics;

public class SlotGameController implements GameController {

    private Round normalRound = new NormalRound();
    private Round freeRound = new FreeRound();
    private SlotGameModel machine = new SlotGameModel();
    private Statistics statistics = new Statistics();

    public void play() {


        int spinResult = machine.spin(normalRound);
        statistics.addLoseCoins(normalRound.getRoundCost());
        if (spinResult < 0) {
            statistics.increaseCountLose();
        } else {
            statistics.increaseCountWin();
            statistics.addWinCoins(normalRound.getRoundWin());
        }
        if (machine.wonFreeRound()) {
            int spinFreeResult = machine.spin(freeRound);
            if (spinFreeResult <= 0) {
                statistics.increaseCountLose();
            } else {
                statistics.increaseCountWin();
                statistics.addWinCoins(freeRound.getRoundWin());
            }

        }
        statistics.setRTP(statistics.getCoinWin(), statistics.getCoinLose());
    }

    public Statistics getStatistics() {
        return statistics;
    }

}
