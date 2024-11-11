import java.util.ArrayList;

public class CardDeck {
    private ArrayList<Card> cards;

    CardDeck(String[] carddata) {
        cards = new ArrayList<>(100);
        createCards(carddata);
    }

    public Card getNext() {
        int count = 0;
        Card nextCard = cards.get(count);
        count++;
        return nextCard;
    }

    public void createCards(String[] data) {
        for (int i = 0; i < data.length; i++) {
            String[] values = data[i].split(",");
            String message = values[0];
            int income = Integer.parseInt(values[1]);
            int cost = Integer.parseInt(values[2]);
            String event = values[3];

            Card c = new Card(message, income, cost, event);
            cards.add(c);

        }
    }
}
