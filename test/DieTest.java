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

}