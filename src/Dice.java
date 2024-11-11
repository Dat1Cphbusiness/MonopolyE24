import java.util.Random;

public class Dice {
    public boolean isDouble = true;


   public int rollDiceSum(){
       Random rand = new Random();
       int dice1 = rand.nextInt(1,6);
       int dice2 = rand.nextInt(1,6);
        if(dice1 == dice2){
            isDouble = true;
        }else {
            isDouble = false;
        }
        return dice1 + dice2;
    }
    public boolean getIsDouble(){
       return isDouble;
       }
    }

