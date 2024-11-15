import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DiceTest {

    @Test
    void TestRollDice() {
        Dice dice = new Dice();
        for (int i = 0; i < 1000; i++) {
        int actual = dice.rollDiceSum();
            assertTrue(actual >= 2 && actual <= 12);
        }
    }
}