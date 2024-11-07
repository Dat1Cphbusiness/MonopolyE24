import java.util.ArrayList;

public class CardDeck {
    ArrayList<Card> cards;

    public CardDeck() {
        this.cards = new ArrayList<Card>();
    }// end Constructor

    public Card createCard(String cardData[]) {
     //  for (String currentCard : cardData) {
       //String[] values = cardData[currentCard].split(",")
       //}
        for(int i = 0; i < cardData.length; i++) {
            String[] values = cardData[i].split(",");
            String message = values[i];
            int income = Integer.parseInt(values[i]);
            int cost = Integer.parseInt(values[i]);
            String event = values[i];
            Card c = new Card(message, income, cost, event);
            cards.add(c);
        }
    }
}   // end CardDeck

