import javax.swing.*;
import java.util.Random;

/**
 * Created by natna on 12/12/2016.
 */
public class DiceRoll {

    private Random random = new Random();
    int[] diceRoll = new int[5];


    public DiceRoll() {
        for (int throwFiveDice = 0; throwFiveDice < 5; throwFiveDice++) {
            diceRoll[throwFiveDice] = random.nextInt(6) + 1;

        }

        for (int i = 0; i < 5; i++) {
            System.out.print(diceRoll[i] + ",");
        }
        System.out.println();
    }



}






