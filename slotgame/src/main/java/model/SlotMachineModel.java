package model;

import model.rounds.Round;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SlotMachineModel {

    private List<GameResult> list = new ArrayList<GameResult>();
    private List<GameResult> freeRound = new ArrayList<GameResult>();

    public SlotMachineModel() {
        for (int i = 0; i<=2; i++)
            list.add(GameResult.WIN);
        for (int i = 0; i<=6; i++)
            list.add(GameResult.LOSE);

        freeRound.add(GameResult.FREE_ROUND);
        for (int i = 0; i<=8; i++)
            freeRound.add(GameResult.LOSE);
    }

    public int spin(Round round) {
        return calcWin(round);
    }

    public boolean wonFreeRound() {
        return freeRound.get(random()).equals(GameResult.FREE_ROUND);
    }

    private int calcWin(Round round) {
        int result = -round.getRoundCost();
        int k = random();
        GameResult a = list.get(k);
        if (a.equals(GameResult.WIN)) {
            result += round.getRoundWin();
        }

        return result;
    }

    private int random() {
        Random random = new Random();
        Collections.shuffle(list);
        return random.nextInt(9);
    }

    private enum GameResult {
        LOSE, WIN, FREE_ROUND
    }
}
