import java.util.ArrayList;

public class CardDeck {
    ArrayList<Card> cards;

    public CardDeck() {
        this.cards = new ArrayList<Card>();
    }// end Constructor

    public boolean createCard(String cardData[]) {
     //  for (String currentCard : cardData) {
       //String[] values = cardData[currentCard].split(",")
       //}

        /*
        try {
            for(int i = 0; i < cardData.length; i++) {
                String[] values = cardData[i].split(",");


                String message = values[i];
                int income = Integer.parseInt(values[i]);
                int cost = Integer.parseInt(values[i]);
                String event = values[i];

                Card c = new Card(message, income, cost, event);
                cards.add(c);
            }   // end for-loop
            return true;
        }
        catch (Exception e) {
            return false;
        }   // end try-catch*/

        new FileIO().readData("path");
        return true;
    }   // end createCard()
}   // end CardDeck

