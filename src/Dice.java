import java.util.ArrayList;

public class Dice  {
    private int dice1 = rollDice();
    private int dice2 = rollDice();
    TextUI ui = new TextUI();

    public int getDice1() {
        return dice1;
    }   // end getDice1()

    public int getDice2() {
        return dice2;
    }   // end getDice2()

    public int rollDice() {
        int result = (int) (Math.random() * 6) + 1;

        while (result > 6) {
            result = (int) (Math.random() * 6) + 1;
        }   // end while-loop

        return result;  // returns a number between 1 and 6
    }   // end rollDice()

    public int rollDie(){
        dice1 = rollDice();                     // get a new random int
        dice2 = rollDice();                     // get a new random int
        int[] thisRoll = {dice1, dice2};        // put the 2 new ani values into an array
        int totalDiceEyes = 0;

        for (int i : thisRoll){
            totalDiceEyes += i;        // adds every roll (in this case 2) to an ArrayList 'thisRoll'
        }   // end for-each loop

        ui.displayMsg("You have rolled: " + thisRoll[0] +" + " + thisRoll[1] + " = " + totalDiceEyes);   // calling displayMsg from our TextUI class & typecasting totalDiceEyes
        return totalDiceEyes;
    }   // end roll()

    public boolean rollPrison(){
         boolean result = false;
         dice1 = rollDice();                     // get a new random int
         dice2 = rollDice();                     // get a new random int

            if (dice1 == dice2){
                ui.displayMsg("You have earned your freedom! (" + dice1 + ", " + dice2 + ")");
                result = true;
            } else {
                ui.displayMsg("You still have to stay in prison!\nI'd be productive to think about why you're here (" + dice1 + ", " + dice2 + ")");
                result = false;
            }   // end  if-else statement

        return result;
    }   // end rollPrison()

}   // end Dice