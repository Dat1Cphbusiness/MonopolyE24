public class Chance extends Field {
    private String event;
    Card card;


    public Chance(int id, String label, int cost, int income) {
        super(id, label, cost, income);

    }

    @Override
    public String onLand(Player p) {
        card = Board.cardDeck.getNext();
        String s = super.onLand(p);
        this.cost = card.getCost();
        this.income = card.getIncome();
        this.event = card.getEvent();
        s += "\n Du har trukket et kort fra bunken: " + card.getMessage();


        //todo: findes der kort som giver spilleren en valgmulighed? I så fald skal option sættes til noget som
        //todo: hvis der aldrig gives en valgmulighed skal vi måske bare kalde onAccept herfra?

        return s;
    }

    @Override
    public String toString() {
        return "Chance{" + "event='" + event + '\'' + '}';
    }

  /*  public String processResponse(Player p) {
        return "Behandle svar for spiller " + p.getName();
    }*/

    protected String onAccept(Player p) {
        switch (event) {
            case "pay":
                p.pay(card.getCost());
                break;
            case "reward":
                p.receive(card.getIncome());
                break;
            case "rewardFromPlayers":
                // todo: få fat i listen af spillere fra Game.
                //  Gennemløb listen og send penge fra alle spillere (som ikke er p) til p
                //  otherplayer.pay(card.getIncome(), p);

                break;
            case "prison":
                p.updatePosition(31);
                break;
                // todo: hvordan kan vi rykke spilleren til et bestemt felt, og samtidig aktivere det felt der landes på
                //  - Find feltet spilleren skal hen på.
                //  - kald til landAndAct med feltet som argument.


            /* case "moveTo":
                int m = position - moveToPosition;
                p.updatePosition(moveToPosition);
            */
        }
        //todo: kan vi gøre beskeden mere specifik så den afspejler den event der lige er sket?
        return "Spiller " + p.getName() + " har accepteret tilbuddet.";
    }

        protected String onReject (Player p){

        return "Spiller " + p.getName() + " afviste tilbuddet.";
        }
    }
