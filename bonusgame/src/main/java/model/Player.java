package model;

public class Player {
    private int purse = 1000;

    public int getPurse() {
        return purse;
    }

    void replenishment(){
        purse+=1000;
    }
}
