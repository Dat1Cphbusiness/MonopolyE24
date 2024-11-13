import java.util.ArrayList;

public class CardDeck {
    private Card cards[];
    private int counter;

    public CardDeck(String[] carddata) {

        this.cards = new Card[carddata.length];
        createCards(carddata);
        counter = 0;
    }

    public void createCards(String[] data){

        for (int i = 0; i < data.length; i++){
            String [] values = data[i].split(",");//"Tag med den nærmeste færge (Passerer du START får du 4000 kr.), 0, 0, moveTo"
            String message = values[0];                         //Mismatch datatype med Card klassen  "int message = Integer.parseInt(values[0]);             //Skal muligvis ændres til en ny type kaldet "Field"
            int income = Integer.parseInt(values[1].trim());//"100"
            int cost = Integer.parseInt(values[2].trim());
            String event = values[3];

            Card c = new Card(message, income, cost, event);

            cards[i] = c;
        }
    }

    public Card getNext(){
        Card card = cards[counter];
        counter++;
        return card;
    }
}
