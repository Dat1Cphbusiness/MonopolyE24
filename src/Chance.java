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
        s += "\n Du har trukket et kort fra bunken: " + card.getMessage();
        return s;
    }

    @Override
    public String toString() {
        return "Chance{" + "event='" + event + '\'' + '}';
    }

    public String processResponse(Player p) {
        return "Behandle svar for spiller " + p.getName();
    }

    protected String onAccept(Player p) {
        switch (event) {
            case "pay":
                p.pay(Card.getCost(), p.getName());
                break;
            case "reward":
                p.receive(Card.getIncome());
                break;
            case "rewardFromPlayer":
                p.pay(Card.getIncome(), p.getName());
                break;
            case "prison":
                p.updatePosition(31);
                break;
            case "moveTo":
                if (p.getPosition() > Card.getMoveToPosition()) {
                    int m = Card.getMoveToPosition() - p.getPosition();
                    p.updatePosition(m);
                } else {
                    int m = Math.abs(p.getPosition() - 40) + Card.getMoveToPosition();
                    p.updatePosition(m);
                }
                    break;
                }
                return "Spiller " + p.getName() + " har accepteret tilbuddet.";
        }

        protected String onReject (Player p){
            return "Spiller " + p.getName() + " afviste tilbuddet.";
        }
    }
