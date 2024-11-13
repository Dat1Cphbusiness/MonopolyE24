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

    public String onAccept(Player p) {
        switch(event) {
            case "reward":
                p.receive(income);
                break;
            case "payment":
                p.pay(cost);
                break;
            case "paymentPerProperty":
                p.pay(cost*);  //betal pr hus/hotel. skal bruge metode til at hente antal huse/hoteller
                break;
            case "moveNumberOfFields":
                p.updatePosition(/* value */);
                if(startPassed()) {
                    p.receive(4000);
                }
                break;
            case "moveTo":
                if(income > p.getPosition()) {
                    p.updatePosition(income - p.getPosition());
                }
                if (income < p.getPosition()) {
                    p.setPosition(1);
                    p.receive(4000);
                    p.updatePosition(income- p.getPosition());
                }
                break;
            case "moveToNearest":
                break;
            case "doubleRentPaymentToPlayer":
                p.updatePosition(3);
                p.pay(cost*2, /*other player*/

                break;
            case "prison":

                break;

            case "joker":
                //get out of jail card
                break;

        }
    }
}
