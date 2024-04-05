import java.util.ArrayList;
import java.util.Collections;

public class CardDeck{

    private static ArrayList<Card> cards;
    private static ArrayList<Card> cardsShuffled = new ArrayList<>(cards);
    private static int currentCardIndex = 0;
    public CardDeck(String[] carddata){

        this.cards = new ArrayList<Card>();
        createCards(carddata);
    }

    public void createCards(String[] carddata){
        for (int i = 0; i < carddata.length; i++) {
            String[] values = carddata[i].split(",");
            String message = values[0];
            int income = Integer.parseInt(values[1]);
            int cost = Integer.parseInt(values[2]);
            String event = values[3];
            Card c = new Card(message, income, cost, event);

        }
    }
    public Card getNext(){
        Collections.shuffle(cardsShuffled);

        Card nextObject = cardsShuffled.get(currentCardIndex);

        currentCardIndex = (currentCardIndex + 1) % cards.size();

        return nextObject;
    }

}
