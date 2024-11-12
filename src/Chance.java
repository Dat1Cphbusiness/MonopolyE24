public class Chance extends Field {
    private String event;
    private CardDeck cardDeck;

    public Chance(int id, String label, int cost, int income, String event, CardDeck cardDeck) {
        super(id, label, cost, income);
        this.event = event;
        this.cardDeck = cardDeck;
    }

    @Override
    public String onLand(Player p) {
        Card card = Game.cardDeck.getNext();
        String s = super.onLand(p);
        this.cost = card.getCost();
        this.income = card.getIncome();
        this.event = card.getEvent();
        s += "\n Du har trukket et kort fra bunken: "+card.getMessage();
        return s;
    }
}
