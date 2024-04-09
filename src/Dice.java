import java.util.Random;

public class Dice {

    private boolean isDouble;
    Random rand = new Random();
    private int dice1;
    private int dice2;

    public int rollDiceSum(){
       dice1  = rand.nextInt(6)+1;
       dice2 = rand.nextInt(6)+1;
       int sum = dice1 + dice2;

        if(dice1 == dice2){
           isDouble = true;
        }else{
            isDouble = false;
        }
        return sum;


    }

    public boolean isDouble(){
        return isDouble;

    }



}
