package view;

import java.io.IOException;
import java.util.Properties;

public class View {

    public static final String PRESS_TO_START = "PRESS_TO_START";
    public static final String PURSE_UPDATED = "PURSE_UPDATED";
    public static final String LOSE_MESS = "LOSE_MESS";
    public static final String LOSE_PERC_MESS = "LOSE_PERC_MESS";
    public static final String WIN_MESS = "WIN_MESS";
    public static final String WIN_PERC_MESS = "WIN_PERC_MESS";
    public static final String FREE_ROUND = "FREE_ROUND";
    public static final String GAME_END = "GAME_END";
    public static final String ENTER_NUMBERS = "ENTER_NUMBERS";
    public static final String YOU_WON_BONUS_ROUND = "YOU_WON_BONUS_ROUND";
    public static final String CORRECT_BOX = "CORRECT_BOX";
    public static final String WRONG_BOX = "WRONG_BOX";


    private Properties prop = new Properties();

    public View() {
        try {
            prop.load(getClass().getClassLoader()
                            .getResourceAsStream("view.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printMessage(String messageKey) {
        System.out.println(prop.getProperty(messageKey));
    }

    public void printLose(int amount) {
        System.out.println(prop.getProperty(LOSE_MESS) + amount);
    }

    public void printWin(int amount) {
        System.out.println(prop.getProperty(WIN_MESS) + amount);
    }

    public void printLosePercent(double amount) {
        System.out.println(prop.getProperty(LOSE_PERC_MESS) + amount);
    }

    public void printWinPercent(double amount) {
        System.out.println(prop.getProperty(WIN_PERC_MESS) + amount);
    }

}
