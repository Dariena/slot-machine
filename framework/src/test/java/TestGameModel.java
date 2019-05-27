import model.GameModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;


public class TestGameModel {
    private GameModel gameModel = new GameModel();
    private Random random = new Random();

    @Test
    public void CheckListSize(){
        List list = gameModel.fillPercentageList(random.nextInt(100));
        assertEquals(100, list.size());
    }

    @Test
    public void testFillPercentageList(){
        int count=0;
        List list = gameModel.fillPercentageList(10);
        for (Object o : list) {
            if (o.equals(GameModel.GameResult.WIN))
                count++;
        }
        assertEquals(10, count);
    }


    }


