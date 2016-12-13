import javax.swing.*;

/**
 * Created by natna on 12/12/2016.
 */
public class GamePlay {


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new YahtzeeBoard("Yahtzee Board");
            }
        });
    }
}
