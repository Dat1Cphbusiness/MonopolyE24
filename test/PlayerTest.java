import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {



    @Test
    public void updatePosition(){
        //arrange
        Player p = new Player("Egon");
        //act
        int actual = p.updatePosition(10);
        int expected = 11;
        //assert
        assertEquals(expected, actual);

    }
    @Test
    public void updatePositionPassingStart(){
        //arrange
        Player p = new Player("Egon");


        //act
        int actual = p.updatePosition(42);
        int expected = 3;
        //assert
        assertEquals(expected, actual);
        assertEquals(34000, p.getWorthInCash());

    }
}