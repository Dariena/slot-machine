package controller;

import model.Player;
import model.BoxPickingModel;
import model.Statistics;
import model.rounds.Basic;
import model.rounds.Bonus;
import model.rounds.Round;
import view.View;

import java.util.Scanner;

public class GameController {

    private Round basicRound = new Basic();
    private Round bonusRound = new Bonus();
    private BoxPickingModel machine = new BoxPickingModel();
    private Player player = new Player();
    private Statistics statistics = new Statistics();
    private Scanner sc = new Scanner(System.in);
    private View view = new View();

    public void play() {

        boolean finished = false;
        while (!finished) {
            view.printMessage(View.PRESS_TO_START);
            sc.nextLine();

            if (player.getPurse() <= 0) {
                player.replenishment();
                System.out.println();
            }

            if (machine.wonBonusRound()) {
                //System.out.println("You won bonus round");
                view.printMessage(View.YOU_WON_BONUS_ROUND);
                statistics.increaseCountWin(basicRound.getRoundWin());
                for (int i = 0; i <= 3; i++) {
                    //System.out.println("Enter box number 1-5");
                    view.printMessage(View.ENTER_NUMBERS);
                    if (machine.checkBox(sc.nextInt())) {
                        //System.out.println("You chose correct box and won " + bonusRound.getRoundWin());
                        view.printMessage(View.CORRECT_BOX);
                        player.addToPurse(bonusRound.getRoundWin());
                        statistics.increaseCountWin(bonusRound.getRoundWin());
                    } else {
                        statistics.increaseCountLose(bonusRound.getRoundCost());
                        //System.out.println("You chose wrong box and lose");
                        view.printMessage(View.WRONG_BOX);
                        finished = true;
                        break;
                    }
                }
            } else {
                view.printLose(basicRound.getRoundCost());
                statistics.increaseCountLose(basicRound.getRoundCost());
            }
        }

        view.printMessage(View.GAME_END);
        view.printLose(statistics.getCountLose());
        view.printWin(statistics.getCountWin());
        view.printWinPercent(statistics.getPercentOfWin() * 100);
        view.printLosePercent(statistics.getPercentOfLose() * 100);
    }
}
