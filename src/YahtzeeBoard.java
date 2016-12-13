import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by natna on 12/12/2016.
 */
public class YahtzeeBoard extends JFrame {
    private JPanel mainBoard;
    private JButton btnPlayer;
    private JPanel scoreBoard;
    private JLabel fullHouse;
    private JLabel threeKind;
    private JLabel fourKind;
    private JLabel smallStreet;
    private JLabel lblLargeStreet;
    private JLabel lblYahtzee;
    private JLabel lblAce;
    private JLabel lblTwos;
    private JLabel lblThrees;
    private JLabel lblFours;
    private JLabel lblFives;
    private JLabel lblSixs;
    private JLabel upperSum;
    private JButton playerTwoButton;
    static int sumUpper;


    public YahtzeeBoard() {

    }


    public YahtzeeBoard(String name) {

        super(name);

        add(mainBoard);
        setSize(1000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        Actions();
    }


    private void Actions() {

        btnPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiceRoll diceRoll = new DiceRoll();
                int dice[] = diceRoll.diceRoll;
                int diceface = 0;
                Tree tree = new Tree();

                while (diceface < 5) {

                    tree.insert(dice[diceface]);
                    diceface++;
                }

                UppDateVariables();
                uppDateScreen(dice);
                uppdateUpperScore(dice);

            }
        });


        lblAce.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                lblAce.setEnabled(false);
            }
        });

    }

    private void UppDateVariables() {
        lblAce.setText("");
        lblThrees.setText("");
        lblTwos.setText("");
        lblLargeStreet.setText("");
        lblYahtzee.setText("");
        fullHouse.setText("");
        smallStreet.setText("");
        fourKind.setText("");
        lblFives.setText("");
        lblSixs.setText("");
        lblFours.setText("");
        upperSum.setText("");
        threeKind.setText("");

    }

    private void uppdateUpperScore(int[] dice) {

        int diceface = 0;
        Tree tree = new Tree();

        while (diceface < 5) {

            tree.insert(dice[diceface]);
            diceface++;
        }


        for (int i = 0; i < 5; i++) {
            Node find = tree.find(dice[i]);
            if (find.value == 1) {
                lblAce.setText(Integer.toString(find.value * find.freq));
            }
            if (find.value == 2) {
                lblTwos.setText(Integer.toString(find.value * find.freq));
            }
            if (find.value == 3) {
                lblThrees.setText(Integer.toString(find.value * find.freq));
            }

            if (find.value == 4) {
                lblFours.setText(Integer.toString(find.value * find.freq));
            }

            if (find.value == 5) {
                lblFives.setText(Integer.toString(find.value * find.freq));
            }
            if (find.value == 6) {
                lblSixs.setText(Integer.toString(find.value * find.freq));
            }

        }

        //sumUpper=tree.sumAllValues();
        // upperSum.setText(Integer.toString(sumUpper));


        // return sumUpper;


    }

    private void uppDateScreen(int[] dice) {
        boolean isFourOfAKind = false;
        boolean isFiveOfAkind = false;
        boolean isThreeOfAkind = false;
        boolean isFullHouse = false;
        boolean isSmallStreet = false;
        boolean isLargeStreet = false;
        Tree tree = new Tree();


        for (int j = 0; j < 5; j++) {
            Node nodeCategory = tree.find(dice[j]);  //Find a node and check the frequency
            if (nodeCategory != null) {
                if (nodeCategory.freq >= 3) isThreeOfAkind = true; //if frequency is 3 it is Three of a kind
                if (nodeCategory.freq >= 4) isFourOfAKind = true;   //if frequency is 4 it is Large of a kind
                if (nodeCategory.freq == 5) isFiveOfAkind = true; //if frequency is 5 it is Yatzy
            }

        }


        if (isThreeOfAkind) {
            int checkTwoPair = 0;
            while (checkTwoPair < 5) {
                Node isFullHouseNode = tree.find(dice[checkTwoPair]);
                if (isFullHouseNode.freq == 2) {
                    isFullHouse = true;
                    break;
                }
                checkTwoPair++;
            }
        }

        bubbleSort(dice);
        isLargeStreet = checkLargeStreet(dice);
        isFiveOfAkind = checkYahtzee(dice);


        if (isThreeOfAkind) threeKind.setText(Integer.toString(tree.sumAllValues()));
        if (isFourOfAKind) fourKind.setText(Integer.toString(tree.sumAllValues()));

        if (isFullHouse) fullHouse.setText(Integer.toString(Dice.Full_HOuse.getDiceFace()));

        if (isLargeStreet) lblLargeStreet.setText(Integer.toString(Dice.LARGE_STRAIGHT.getDiceFace()));

        if (isFiveOfAkind) lblYahtzee.setText(Integer.toString(Dice.YAHTZEE.getDiceFace()));


    }


    private boolean checkLargeStreet(int[] diceRoll) {
        if (diceRoll[0] == 1 && diceRoll[1] == 2 && diceRoll[2] == 3 && diceRoll[3] == 4 && diceRoll[4] == 5)
            return true;
        if (diceRoll[0] == 2 && diceRoll[1] == 3 && diceRoll[2] == 4 && diceRoll[3] == 5 && diceRoll[4] == 6)
            return true;

        return false;
    }

    private boolean checkYahtzee(int[] diceRoll) {

        if (diceRoll[0] != diceRoll[diceRoll.length - 1]) return false;
        return true;
    }

    ///Bubble sort
    private void bubbleSort(int[] diceRoll) {

        for (int i = 0; i < diceRoll.length - 1; i++) {

            for (int j = 0; j < diceRoll.length - i - 1; j++) {
                if (diceRoll[j + 1] < diceRoll[j]) { // two items are out of order, so swap them swap(list,j,j+1); isSorted = false; } } if (isSorted) {
                    swap(j, j + 1, diceRoll);
                }
            }
        } //for outer
    } // method bubble sort


    //swap values
    private void swap(int j, int m, int[] diceRoll) {

        int temp = diceRoll[j];
        diceRoll[j] = diceRoll[m];
        diceRoll[m] = temp;
    }  //end of swap method


}  // end of class
