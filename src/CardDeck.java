import java.util.ArrayList;

public class CardDeck{

    private ArrayList<Card> cards;
   private int counter = -1;
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
            cards.add(c);

        }
    }
    public Card getNext() {

        if (cards.size() == counter) {
            counter = 0;

        }else counter++;

        return cards.get(counter);
    }



}
