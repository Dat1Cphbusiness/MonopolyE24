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
        Player p = new Player("Egon", 30000);

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
        Player p = new Player("Egon", 30000);
        Field f = game.board.getField(40); // rådhuspladsen koster 8000
        //act
        p.buyProperty(f);
        int actual = p.getWorthInCash();
        int expected = 22000;

        //assert
        assertEquals(expected, actual);

    }

    @Test
    void pay_Returns_True_When_Sufficient_Balance() {
        // Arrange
        Player p = new Player("Egon", 30000);

        // Act
        boolean actual = p.pay(30000);

        // Assert
        assertTrue(actual);
    }

    @Test
    void pay_Returns_False_When_Insuffucient_Balance() {
        // Arrange
        Player p = new Player("Egon", 30000);

        // Act
        boolean actual = p.pay(30001);

        // Assert
        assertFalse(actual);
    }

    @Test
    void has_Sufficient_Money_To_Pay() {
        // Arrange
        Player p1 = new Player("Egon", 30000);
        Player p2 = new Player("Benny", 30000);

        // Act
        boolean actual = p1.pay(30000, p2);

        // Assert
        assertTrue(actual);
    }

    @Test
    void has_Insufficient_Money_To_Pay() {
        // Arrange
        Player p1 = new Player("Egon", 30000);
        Player p2 = new Player("Benny", 30000);

        // Act
        boolean actual = p1.pay(30001, p2);

        // Assert
        assertFalse(actual);
    }

    @Test
    void has_Sufficient_Money_To_Buy_Property() {
        // Arrange
        Player p = new Player("Egon", 30000);
        Field f = new Field(0, "test", 30000, 0);

        // Act
        boolean actual = p.buyProperty(f);

        // Assert
        assertTrue(actual);
    }

    @Test
    void has_Insufficient_Money_To_Buy_Property() {
        // Arrange
        Player p = new Player("Egon", 30000);
        Field f = new Field(0, "test", 30001, 0);

        // Act
        boolean actual = p.buyProperty(f);

        // Assert
        assertFalse(actual);
    }

    @Test
    void moveToPrison() {
        // Arrange
        Player p = new Player("Jeppe", 30000);

        // Act
        int actual = p.moveToPrison();

        // Assert
        assertEquals(31, actual);
    }
}