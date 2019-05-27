import controller.BoxPickingController;


public class Main {
    public static void main(String... args) {
        int counter = 1000000;

        BoxPickingController controller = new BoxPickingController();

        for (int i = 0; i < counter; i++) {
            controller.play();
        }

        controller.getStatistics().showAllStatistic();
    }

}

