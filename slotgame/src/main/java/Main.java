import controller.SlotGameController;


public class Main {

    public static void main(String... args) {
        int counter = 1000000;

        SlotGameController controller = new SlotGameController();

        for (int i = 0; i < counter; i++) {
            controller.play();
        }

        controller.getStatistics().showAllStatistic();
    }


}

