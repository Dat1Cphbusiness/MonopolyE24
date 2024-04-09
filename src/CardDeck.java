import java.util.ArrayList;
import java.util.Collections;

public class CardDeck{

    private ArrayList<Card> cards;
   private int counter = 0;


    public CardDeck(String[] carddata){
        this.cards = new ArrayList<Card>();
        createCards(carddata);
        Collections.shuffle(cards);
    }

    public void createCards(String[] carddata){
        for (int i = 0; i < carddata.length; i++) {
            String[] values = carddata[i].split(",");
            String message = values[0];
            int income = Integer.parseInt(values[1].trim());
            int cost = Integer.parseInt(values[2].trim());
            String event = values[3].trim();
            Card c = new Card(message, income, cost, event);
            cards.add(c);
        }
    }
    public Card getNext() {

        if (cards.size() == counter) {
            counter = 0;
            Collections.shuffle(cards);

        }
        Card nextCard = cards.get(counter);
        counter++;
        return nextCard;

    }



}
