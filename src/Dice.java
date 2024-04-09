import java.util.Random;

public class Dice {

    private boolean isDouble;
    Random rand = new Random();
    private int die1;
    private int die2;
    private int[] dice = new int[2];




    public int rollDiceSum(){
        die1 = rand.nextInt(6)+1;
        die2 = rand.nextInt(6)+1;
        int sum = die1 + die2;


        if(die1 == die2){
            isDouble = true;
        }else{
            isDouble = false;
        }
        return sum;
    }

    public boolean isDouble(){
        return isDouble;

    }

    public int [] getDice(){
        dice[0] = this.die1;
        dice[1] = this.die2;
        return dice;
    }



}
