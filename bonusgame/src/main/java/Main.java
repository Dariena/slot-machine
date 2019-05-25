import model.*;


public class Main {
    public static void main(String... args) {
        Model model = new Model();
        int countLose = 0;
        int countWin = 0;
        int coinsInCirculation = 10;
        double coinWin = 0;
        double coinBet = 0;
        double RTP;
        double percentOfWin;
        double countOfTrying = 10;
        double realTryings = countOfTrying;
        double percentOfLose;
        Round normalRound = new Normal();
        Round freeRound = new Free();
        SlotMachine machine = new SlotMachine();

        for (int i = 0; i < countOfTrying; i++) {

            int won = machine.spin(normalRound);
            coinWin += won;
            coinBet += normalRound.getRoundCost();
            // ----------------------
            if (won < 0) {
                countLose ++;
            } else {
                countWin ++;
            }
            // ----------------------
            if (machine.wonFreeRound()) {
                int wonFree = machine.spin(freeRound);
                coinBet += normalRound.getRoundCost();
                coinWin += wonFree;
                if (wonFree < 0) {
                    countLose ++;
                } else {
                    countWin ++;
                }
                realTryings += 1;
            }

        }

        // coinWin = countWin * coinsInCirculation;
        // coinBet = countLose * coinsInCirculation;
        percentOfWin = countWin / realTryings;
        percentOfLose = countLose / realTryings;
        RTP = coinWin / coinBet;

        /* System.out.println("Count Win " + countWin);*/
        System.out.println("Percent of Winning " + percentOfWin);
        /* System.out.println("Count Lose " + countLose);*/
        System.out.println("Percent of Losing " + percentOfLose);
        System.out.println("RTP " + RTP);
    }


}

