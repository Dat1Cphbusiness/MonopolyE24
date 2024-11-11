public class Chance extends Field{

    private String event;

    public Chance(int id, String label, int cost, int income, CardDeck cardDeck){
        super(id,label,cost,income);

    }

    @Override
    public String onLand(Player p) {
        Card card = Game.cardDeck.getNext();
        String s = super.onLand(p);
        this.cost = card.getCost();
        this.income = card.getIncome();
        this.event = card.getEvent();
        s += "\n You have drawn a card from the deck: " + card.getMessage();
        return s;
    }
    
}
