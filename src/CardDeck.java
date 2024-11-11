import java.util.ArrayList;

public class CardDeck {
    private ArrayList<Card> cards;
    private int counter;

    public CardDeck(String[] carddata) {
        this.cards = new ArrayList<>(100);
       /* for (String data : carddata) {
            createCards((data).strip());
        }*/
        counter = 0;
    }

    public void createCards(String data){
        String[] values = data.replace(" ", "").split(",");
        for (int i = 0; i < 6; i++){
            String message = values[0];                         //Mismatch datatype med Card klassen  "int message = Integer.parseInt(values[0]);             //Skal muligvis ændres til en ny type kaldet "Field"
            int income = Integer.parseInt(values[1]);
            int cost = Integer.parseInt(values[2]);
            String event = values[3];

            Card c = new Card(message, income, cost, event);
            cards.add(c);
        }
    }

    public Card getNext(){
        return cards.get(counter++);
    }
}
