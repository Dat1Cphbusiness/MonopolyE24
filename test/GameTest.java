import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void runGameLoop() {
        ArrayList<Player> players = new ArrayList<>();
        Player p1 = new Player("Emil", -20000);
        Player p2 = new Player("Peter", 30000);
        players.add(p1);
        players.add(p2);

        int count = 0;
        Player currentPlayer = players.get(count);
        // if the current players balance = zero it will remove the player from the game
        if(currentPlayer.getWorthInCash() <= 0) {
            players.remove(currentPlayer);
        }
        String expected = "Peter, 30000";
        String actual = String.valueOf(players.get(0));

        assertEquals(expected, actual);
    }

}
