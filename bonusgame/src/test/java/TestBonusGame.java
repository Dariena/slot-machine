import controller.BoxPickingController;
import model.BoxPickingModel;
import model.rounds.BonusRound;
import org.junit.Test;
import round.Round;
import statistic.Statistics;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestBonusGame {

    private Random random = new Random();
    private BoxPickingModel model = new BoxPickingModel();
    private Statistics statistics = new Statistics();
    private Round bonusRound = new BonusRound();
    BoxPickingController controller = new BoxPickingController();

    @Test
    public void CheckBasicWinPercents() {
        assertEquals(10, model.getBasicWinPercents());
    }

    @Test
    public void CheckBoxWinAmount() {
        assertEquals(4, model.getBoxWinAmount());
    }

    @Test
    public void TestCountWin() {
        if (model.wonBonusRound()) {
            statistics.increaseCountWin();
            assertEquals(1, statistics.getCountWin());


        }
    }

    @Test
    public void TestCountLose() {
        if (model.wonBonusRound()) {
            statistics.increaseCountLose();
            assertEquals(1, statistics.getCountLose());


        }

    }

    @Test
    public void TestCoinWin() {
        if (model.checkBox(random.nextInt(5))) {
            statistics.addWinCoins(5);
        }
        assertEquals(5, statistics.getCoinWin());

    }

    @Test
    public void TestRTP() {
        for (int i = 0; i < 100; i++) {
            controller.play();
        }
        assertTrue(statistics.getRTP()<=1);

    }

    @Test
    public void checkPercentOfWin(){
        for (int i = 0; i < 100; i++) {
            controller.play();
        }
        assertTrue(statistics.getPercentOfWin()<=0.1);

    }
    @Test
    public void checkPercentOfLose(){
        for (int i = 0; i < 100; i++) {
            controller.play();
        }
        assertTrue(statistics.getPercentOfLose()<=0.9);

    }
}