package model;

public class SlotMachine {

    Model model = new Model();
    Player player = new Player();

    public int spin(Round round) {
        return calcWin(round);
    }

    public boolean wonFreeRound() {
        return model.freeRound.get(model.random()).equals("Free Round");
    }

    private int calcWin(Round round) {
        if(player.getPurse()<=0){
            player.replenishment();
        }
        int result = player.getPurse()-round.getRoundCost();
        int k = model.random();
        String a = model.list.get(k);
        if (a.equals("WIN")) {
            result += round.getRoundWin();
        }

        return result;
    }
}
