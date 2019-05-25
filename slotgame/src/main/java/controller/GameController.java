package controller;

import model.Player;
import model.SlotMachineModel;
import model.Statistics;
import model.rounds.Free;
import model.rounds.Normal;
import model.rounds.Round;
import view.View;

import java.util.Scanner;

public class GameController {

    private Round normalRound = new Normal();
    private Round freeRound = new Free();
    private SlotMachineModel machine = new SlotMachineModel();
    private Player player = new Player();
    private Statistics statistics = new Statistics();
    private Scanner sc = new Scanner(System.in);
    private View view = new View();

    public void play() {

        while (!sc.nextLine().equals("1")) {
            view.printMessage(View.PRESS_TO_START);
            sc.nextLine();

            if (player.getPurse() <= 0) {
                player.replenishment();
                System.out.println();
            }

            int spinResult = machine.spin(normalRound);
            player.addToPurse(spinResult);
            view.printMessage(View.PURSE_UPDATED);
            if (spinResult < 0) {
                view.printLose(normalRound.getRoundCost());
                statistics.increaseCountLose(normalRound.getRoundCost());
            } else {
                view.printWin(normalRound.getRoundWin() - normalRound.getRoundCost());
                statistics.increaseCountWin(normalRound.getRoundWin());
            }
            if (machine.wonFreeRound()) {
                view.printMessage(View.FREE_ROUND);
                int spinFreeResult = machine.spin(freeRound);
                if (spinFreeResult <= 0) {
                    view.printLose(freeRound.getRoundCost());
                    statistics.increaseCountLose(freeRound.getRoundCost());
                } else {
                    view.printWin(freeRound.getRoundWin());
                    statistics.increaseCountWin(freeRound.getRoundWin());
                }
                player.addToPurse(spinFreeResult);
            }
        }

        view.printMessage(View.GAME_END);
        view.printLose(statistics.getCountLose());
        view.printWin(statistics.getCountWin());
        view.printWinPercent(statistics.getPercentOfWin() * 100);
        view.printLosePercent(statistics.getPercentOfLose() * 100);
    }
}
