package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

 public class GameModel {

    public List fillPercentageList(int winPercent) {
        List<GameResult> list = new ArrayList<GameResult>();
        for (int i = 0; i < winPercent; i ++) {
            list.add(GameResult.WIN);
        }
        for (int i = 0; i < 100 - winPercent; i ++) {
            list.add(GameResult.LOSE);
        }

        return list;
    }

     public int random(List list) {
        Random random = new Random();
        Collections.shuffle(list);
        return random.nextInt(list.size() - 1);
    }

    public enum GameResult {
        LOSE, WIN
    }
}
