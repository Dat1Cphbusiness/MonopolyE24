
import java.util.Random;

public class Dice {

    private boolean isDouble;



    public boolean getIsDouble(){
        return isDouble;

    }
    public int rollDiceSum(){
        Random random = new Random();

        // Generate two random integers (e.g., between 0 and 100)
        int dice1 = random.nextInt((6)+1); // Generates a number from 0 to 99
        int dice2 = random.nextInt((6)+1);

        if (dice1 == dice2) {
            isDouble = true;
            System.out.println("You rolled a double!: " + dice1);
        } else {
            isDouble = false;
            System.out.println("The dice doesn't have the same number:  " + dice1 + " and " + dice2);
        }


            int sum = dice1 + dice2;


        System.out.println("Sum of dice: " + sum);


        return sum;



        }



}
