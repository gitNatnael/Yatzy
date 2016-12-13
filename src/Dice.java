/**
 * Created by natna on 12/2/2016.
 */
public enum Dice {

    Ace(1),
    Twos(2),
    Threes(3),
    Four(4),
    Five(5),
    Six(6),
    Full_HOuse(25),
    SMALL_STRAIGHT(30),
    LARGE_STRAIGHT(40),
    YAHTZEE(50),
    CHANCE(14);

    private final int diceValue;

    private Dice(int diceValue) {
        this.diceValue = diceValue;
    }
    public int getDiceFace() {
        return diceValue;

    }

}
