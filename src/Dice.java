public class Dice {
    public boolean isDouble;

    public int rollDiceSum(){
        int dice1 = (int) (Math.random()*6) + 1;
        int dice2 = (int) (Math.random()*6) + 1;
        isDouble = dice1 == dice2;
        return dice1 + dice2;
    }

}
