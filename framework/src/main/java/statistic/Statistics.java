package statistic;

import view.View;

public class Statistics {
    private double percentOfWin;
    private double percentOfLose;
    private double RTP;
    private int countLose = 0;
    private int countWin = 0;
    private int coinWin = 0;
    private int coinLose = 0;
    private View view = new View();

    public double getPercentOfWin() {
        return percentOfWin;
    }

    public double getPercentOfLose() {
        return percentOfLose;
    }

    public double getRTP() {
        return RTP;
    }

    public void setRTP(double coinWin, double coinBet) {
        RTP = coinWin / coinBet;
    }


    public int getCoinWin() {
        return coinWin;
    }

    public int getCoinLose() {
        return coinLose;
    }

    public void increaseCountLose() {
        countLose++;
        percentOfLose = (double)(countLose) / (countWin + countLose);
        percentOfWin = (double)(countWin) / (countWin + countLose);
    }

    public void increaseCountWin() {
        countWin++;
        percentOfLose = (double) countLose / (countWin + countLose);
        percentOfWin = (double) countWin / (countWin + countLose);
    }

    public int getCountLose() {
        return countLose;
    }

    public int getCountWin() {
        return countWin;
    }

    public void addWinCoins(int coins) {
        coinWin+=coins;
    }

    public void addLoseCoins(int coins) {
        coinLose+=coins;
    }

    public void showAllStatistic() {
        view.printMessage(View.GAME_END);
        view.printLose(getCountLose());
        view.printWin(getCountWin());
        view.printWinPercent(getPercentOfWin() * 100);
        view.printLosePercent(getPercentOfLose() * 100);
        view.printRTP(getRTP());
    }
}
