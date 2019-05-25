package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Model {
    public List<String> list = new ArrayList<String>();
    public List<String> freeRound = new ArrayList<String>();

    public Model() {

        list.add("WIN");
        list.add("WIN");
        list.add("WIN");
        list.add("LOSE");
        list.add("LOSE");
        list.add("LOSE");
        list.add("LOSE");
        list.add("LOSE");
        list.add("LOSE");
        list.add("LOSE");
        list.add("LOSE");

        freeRound.add("Free Round");
        freeRound.add("LOSE");
        freeRound.add("LOSE");
        freeRound.add("LOSE");
        freeRound.add("LOSE");
        freeRound.add("LOSE");
        freeRound.add("LOSE");
        freeRound.add("LOSE");
        freeRound.add("LOSE");
        freeRound.add("LOSE");

    }

    public int random() {
        Random random = new Random();
        Collections.shuffle(list);
        return random.nextInt(9);
    }

    public void round(){

    }

}
