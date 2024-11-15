import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {


    @Test
 public void rollDiceTest(){

     Dice dice = new Dice();

     int sum = dice.rollDiceSum();
     boolean isDouble = dice.getIsDouble();

     assertTrue(sum > 1 && sum < 13);


 }
}