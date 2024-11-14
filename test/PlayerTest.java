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
        assertEquals(expected, actual);//tjekker at positionen er korrekt
        assertEquals(34000, p.getWorthInCash()); //tjekker at pengene er trukket

    }

    @Test
    public void buyProperty() {
        //arrange

        // Til denne test skal vi bruge et propertyfelt, derfor instantierer vi Game så vi kan bruge setup metoden
        // til at få bygget hele spillepladen og player instanser
        Game game = new Game("Matador");
        game.setupBoard();
        Player p = new Player("Egon"); // Start amount blev fjernet, da det beløb bliver sat ind i acount, der allerede starter med 30000. Så det blir ialt 60000
        Field f = game.board.getField(40); // rådhuspladsen koster 8000
        //act
        p.buyProperty(f);
        int actual = p.getWorthInCash();
        int expected = 22000;

        //assert
        assertEquals(expected, actual); // Den anden fejl findes i plot og property. Income og cost bør blive byttet, så det passer med rækkefølgen i fielddata.

    }
}