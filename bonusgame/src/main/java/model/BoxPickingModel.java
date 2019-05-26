package model;

import model.rounds.Round;

import java.util.*;

public class BoxPickingModel {

    private List<GameResult> list = new ArrayList<GameResult>();
    private List<Boolean> boxes = new ArrayList<Boolean>();

    public BoxPickingModel() {
        list.add(GameResult.WIN);
        for (int i = 0; i<=8; i++)
            list.add(GameResult.LOSE);

        boxes.add(false);
        for (int i = 0; i <= 3; i++) {
            boxes.add(true);
        }
    }

    public boolean wonBonusRound() {
        boolean result = list.get(random()).equals(GameResult.WIN);
        if (result) {
            generateBoxes();
            System.out.println(Arrays.toString(boxes.toArray()));
        }
        return result;
    }

    private void generateBoxes() {
        Collections.shuffle(boxes);
    }

    public boolean checkBox(int index) {
        return boxes.get(index - 1);
    }

    private int random() {
        Random random = new Random();
        Collections.shuffle(list);
        return random.nextInt(9);
    }

    private enum GameResult {
        LOSE, WIN
    }
}
