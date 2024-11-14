import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    Property property = new Property(2, "Rødovrevej", 50, 1200, 1);
    Player p1 = new Player("Egon");
    Player p2 = new Player("Eline");


    @Test
    public void testOnLand_NotOwned() {
        //arrange: instant the property and the player (Owner==null)


        //act: the player lands on plot not owned
        String result = property.onLand(p1);


        //assert: check if the message contains the offer to buy
        assertTrue(result.contains("Vil du købe? (Y/N): "));
        assertTrue(result.contains("Y/N"));
    }

    @Test
    public void testOnLand_AnotherPlayerOwns(){
        //arrange: instant the property and the player
        // har lavet en setOwner i Property(setting the owner to be p2)
        property.setOwner(p2);

        //act: the player lands on plot owned by another
        String result = property.onLand(p1);


        //assert: check if the message contains the offer to buy
        assertTrue(result.contains("Du skal betale "));
        assertTrue(result.contains(". Tast Y for at acceptere"));
    }
}