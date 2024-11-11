import java.util.Random;

public class Dice {
    public boolean isDouble = true;
    Random rand = new Random();

   public int rollDiceSum() {

       int diceOne = rand.nextInt(1, 6);
       int diceTwo = rand.nextInt(1, 6);

       if (diceOne == diceTwo){
           isDouble = true;
       } else {
           isDouble = false;
       }

       return diceOne + diceTwo;
    }


}
