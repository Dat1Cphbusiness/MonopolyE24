public class Chance extends Field {
    private String event;

    public Chance(int id, String label, int cost, int income, String event) {
        super(id, label, cost, income);
        this.event = event;
    }

    @Override
    public String toString() {
        return "Chance{" +
                "event='" + event + '\'' +
                '}';
    }

    public String onLand(Player p) {
        Card card = Board.cardDeck.getNext();
        //Card card = this.deck.getNext();
        String s = super.onLand(p);
        cost = card.getCost();
        income = card.getIncome();
        event = card.getEvent();
        s += "\n Du har trukket er kort fra bunken: " + card.getMessage();
        return s;
    }

    public String processResponse(Player p) {
        return "Process respons for player " + p.getName();
    }

    protected String onAccept(Player p) {
        return "Player " + p.getName() + " has accepterede tilbuddet.";
    }

    protected String onReject(Player p) {
        return "Player " + p.getName() + " afviste tilbuddet.";
    }
}
