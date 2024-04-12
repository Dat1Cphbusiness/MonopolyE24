import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Game game = new Game("Monopoly");
    @Before
    public void setUp() throws Exception {



        Main.games.add(game);
        game.loadPlayerData();
      //  game.currentPlayer = game.getPlayers().get(0);


    }

    @Test
    public void updatePosition() {
        Player p = game.getPlayers().get(0);

        int actual =  p.updatePosition(12);
        int expected = 14;
        assertEquals(expected, actual);

        //Testing startPassed
        Player p1 = game.getPlayers().get(1);

        actual =  p1.updatePosition(10);
        expected = 5;
        assertEquals(expected, actual);

    }


    @Test
    public void getName() {
        Player p = game.getPlayers().get(1);
        String expected = "jesper";
        String actual = p.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void buyProperty() {
    }

    @Test
    public void pay() {
    }

    @Test
    public void receive() {
    }

    @Test
    public void testPay() {
    }

    @Test
    public void collect() {
    }

    @Test
    public void startPassed() {




    }
}