package model;

public class Player {
    private int purse = 1000;

    public void setPurse(int purse) {
        this.purse = purse;
    }

    public int getPurse() {
        return purse;
    }

    public void replenishment(){
        purse+=1000;
    }

    public void addToPurse(int coinForChanges) {
        purse += coinForChanges;
    }
}
