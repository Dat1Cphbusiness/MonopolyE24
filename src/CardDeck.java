public class CardDeck {
    private Card[] cards;
    private int counter;

    public CardDeck(String[] carddata) {
        this.cards = new Card[carddata.length];
        counter = 0;
        createCards(carddata);
    }

    public void createCards(String[] data) {
        for (int i = 0; i < data.length; i++) {
            String[] values = data[i].split(",");
            String message = values[0];                         //Mismatch datatype med Card klassen  "int message = Integer.parseInt(values[0]);             //Skal muligvis ændres til en ny type kaldet "Field"
            int income = Integer.parseInt(values[1]);
            int cost = Integer.parseInt(values[2]);
            String event = values[3];
            int moveToPosition = Integer.parseInt(values[4]);

            Card c = new Card(message, income, cost, event, moveToPosition);
            cards[i] = c;
        }
    }

    public Card getNext() {
        Card c = cards[counter];
        counter++;
        return c;
    }
}
