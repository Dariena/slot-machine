import controller.SlotGameController;
import org.junit.Assert;
import org.junit.Test;
import statistic.Statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSlotGame {

    private Statistics statistics = new Statistics();
    private SlotGameController controller = new SlotGameController();

    @Test
    public void TestCountWin() {
        statistics.increaseCountWin();
        assertEquals(1, statistics.getCountWin());

    }

    @Test
    public void TestCountLose() {
        statistics.increaseCountLose();
        assertEquals(1, statistics.getCountLose());
    }

    @Test
    public void TestCoinWin() {
        statistics.addWinCoins(10);
        Assert.assertEquals(10, statistics.getCoinWin());

    }

    @Test
    public void TestRTP() {
        for (int i = 0; i < 100; i++) {
            controller.play();
        }
        assertTrue(statistics.getRTP() <= 1);

    }

    @Test
    public void checkPercentOfWin() {
        for (int i = 0; i < 100; i++) {
            controller.play();
        }
        assertTrue(statistics.getPercentOfWin() <= 0.7);

    }

    @Test
    public void checkPercentOfLose() {
        for (int i = 0; i < 100; i++) {
            controller.play();
        }
        assertTrue(statistics.getPercentOfLose() <= 0.3);

    }

}