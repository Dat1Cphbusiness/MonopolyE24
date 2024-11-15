import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    @Test
    public void rollDice(){
        //arrange
         Dice d = new Dice();
        for(int i = 0; i< 1000; i++) {
            //act
            int actual = d.rollDiceSum();//et tal mellem 2 og 12
            //assert
            assertTrue(actual >= 2 && actual <= 12);
        }
    }

    @Test
    public void rollDouble() {
        Dice d = new Dice();
        int dice1 = 6;
        int dice2 = 6;

        boolean dieDouble = dice1 == dice2;
        boolean expected = true;
        boolean actual = dieDouble;

        assertEquals(expected, actual);
    }

}