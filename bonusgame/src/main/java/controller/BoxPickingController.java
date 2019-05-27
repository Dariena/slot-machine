package controller;

import model.BoxPickingModel;
import model.rounds.BasicRound;
import model.rounds.BonusRound;
import round.Round;
import statistic.Statistics;

import java.util.Random;

public class BoxPickingController implements GameController {

    private Round basicRound = new BasicRound();
    private Round bonusRound = new BonusRound();
    private BoxPickingModel machine = new BoxPickingModel();
    private Statistics statistics = new Statistics();
    private Random random = new Random();
    int countOfRound = 10000000;

    public void play() {

        boolean finished = false;
        while (!finished) {

            if (machine.wonBonusRound()) {
                statistics.increaseCountWin();
                statistics.addWinCoins(basicRound.getRoundWin());
                for (int i = 0; i <= 3; i++) {
                    if (machine.checkBox(random.nextInt(5))) {
                        statistics.addWinCoins(bonusRound.getRoundWin());
                    } else {
                        finished = true;
                        break;
                    }
                }
            } else {
                statistics.increaseCountLose();
                statistics.addLoseCoins(basicRound.getRoundCost());
            }

        }

    }

    public Statistics getStatistics() {
        statistics.setRTP(statistics.getCoinWin(),10000000);
        return statistics;
    }

}
