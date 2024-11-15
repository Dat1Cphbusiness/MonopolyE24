import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {


    @Test
    public void checksIfPlayerHasMonopoly(){
        //arrange
        // Til denne test skal vi bruge et propertyfelt, derfor instantierer vi Game så vi kan bruge setup metoden
        // til at få bygget hele spillepladen og player instanser
        Game game = new Game("Matador");
        game.setupBoard();
        Player p = new Player("Egon", 30000000);
        Property property = (Property) game.board.getField(4);
        //act
        String notExpectedResult = property.onLand(p);
        p.deeds.add(game.board.getField(2));
        p.deeds.add(game.board.getField(4));

        ((Property) game.board.getField(2)).setOwner(p);
        ((Property) game.board.getField(4)).setOwner(p);

        String result = property.onLand(p);


        //assert
        assertNotEquals(notExpectedResult,result);
    }
}