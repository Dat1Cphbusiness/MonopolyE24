import java.util.ArrayList;

public class CardDeck{

    private ArrayList<Card> cards;
    public CardDeck(String[] carddata){

        this.cards = new ArrayList<Card>();
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

        return null;
    }

}
