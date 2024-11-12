public class Chance extends Field {
    private String event;


    public Chance(int id, String label, int cost, int income) {
        super(id, label, cost, income);
      
    }

    @Override
    public String onLand(Player p) {
        Card card = Board.cardDeck.getNext();
        String s = super.onLand(p);
        this.cost = card.getCost();
        this.income = card.getIncome();
        this.event = card.getEvent();
        s += "\n Du har trukket et kort fra bunken: "+card.getMessage();
        return s;
    }
}
