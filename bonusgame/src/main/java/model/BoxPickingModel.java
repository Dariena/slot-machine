package model;

import java.util.*;

public class BoxPickingModel extends GameModel {

    private List<GameResult> basicList;
    private List<GameResult> boxes;
    private int basicWinPercents = 10;
    private int boxWinAmount = 4;

    public int getBasicWinPercents() {
        return basicWinPercents;
    }

    public int getBoxWinAmount() {
        return boxWinAmount;
    }

    public BoxPickingModel() {
        basicList = fillPercentageList(basicWinPercents);
        boxes = fillPercentageList(boxWinAmount);
    }

    public boolean wonBonusRound() {
        boolean result = basicList.get(random(basicList)).equals(GameResult.WIN);
        if (result) {
            generateBoxes();
        }
        return result;
    }

    private void generateBoxes() {
        Collections.shuffle(boxes);
    }

    public boolean checkBox(int index) {
        return boxes.get(index).equals(GameResult.WIN);
    }

}
