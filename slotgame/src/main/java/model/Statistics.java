package model;

public class Statistics {
    private double percentOfWin;
    private double percentOfLose;
    private double RTP;
    private int countLose = 0;
    private int countWin = 0;
    private int coinWin = 0;
    private int coinLose = 0;

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

    public void increaseCountLose(int coins) {
        countLose++;
        coinLose-=coins;
        percentOfLose = (double)(countLose) / (countWin + countLose);
        percentOfWin = (double)(countWin) / (countWin + countLose);
    }

    public void increaseCountWin(int coins) {
        countWin++;
        coinWin+=coins;
        percentOfLose = (double) countLose / (countWin + countLose);
        percentOfWin = (double) countWin / (countWin + countLose);

    }

    public int getCountLose() {
        return countLose;
    }

    public int getCountWin() {
        return countWin;
    }
}
