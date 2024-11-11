import java.util.Random;
public class Dice {
    public boolean isDouble;

    int rollDiceSum(){
        Random random = new Random();
        int dice1 = (int) random.nextInt(1,7);
        int dice2 = (int) random.nextInt(1,7);
        isDouble = dice1 == dice2;
        return dice1+dice2;
    }
}
