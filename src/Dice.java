import java.util.Random;

public class Dice {
    public boolean isDouble;
    private static final Random random = new Random();

    public int rollDice() {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        isDouble = (die1 == die2);
        return die1 + die2;
    }
}