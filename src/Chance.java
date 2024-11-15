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


        //Da der ikke findes der kort som giver spilleren en valgmulighed, bør vi bare kalde onAccept herfra.
       onAccept(p);
        return s;
    }

    @Override
    public String toString() {
        return card.getMessage()+"," + event ;
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
                p.moveToPrison();
                break;


            case "moveToFerry":
                //todo skal testes
                int b = nearestFarry(p);
                p.setDestination(b);
                Main.games.get(0).throwAndMove();//
                p.setDestination(0);
                break;

            case "doubleRentPaymentToPlayer":
                //todo skal testes - virker dobbelt. Kunne man fjerne denne case og sætte paymentTimes i den forrige case

                int a = nearestFarry(p);
                p.setPaymentTimes(2);
                p.setDestination(a);
                Main.games.get(0).throwAndMove();
                p.setDestination(0);
                p.setPaymentTimes(1);
                break;

            case "moveTo":
                if (p.getPosition() < card.getMoveToPosition()) {
                    int m = card.getMoveToPosition() - p.getPosition();
                    p.setDestination(m);
                    Main.games.get(0).throwAndMove();
                    p.setDestination(0);
                } else {
                    int m = Math.abs(p.getPosition() - 40) + card.getMoveToPosition();
                    p.setDestination(m);
                    Main.games.get(0).throwAndMove();
                    p.setDestination(0);
                }
                break;
            }
        //todo: kan vi gøre beskeden mere specifik så den afspejler den event der lige er sket?
        return "Spiller " + p.getName() + " har accepteret tilbuddet.";
            // todo: hvordan kan vi håndtere at der er trukket et kort der giver imunitet overfor fængsling?
            //  Skal Player klassen have boolean attribut (et flag) der viser om man har et wildcard? Hvor skal dette flag tjekkes henne, så man ikke ryger i fængsel hvis man har wildcard?
        }



        protected String onReject (Player p){
        return "Spiller " + p.getName() + " afviste tilbuddet.";
        }

    public int nearestFarry(Player p) {

        if (p.getPosition() > 36 || p.getPosition() < 6) {
            if (p.getPosition() < 6) {
                int m = 6 - p.getPosition();
                return m;
            } else {
                int m = Math.abs(p.getPosition() - 40) + 6;
                return m;
            }
        }
        else if (p.getPosition() > 6 || p.getPosition() < 16) {
            int m = 16 - p.getPosition();
            return m;
        }
        else if (p.getPosition() > 16 || p.getPosition() < 26) {
            int m = 26 - p.getPosition();
            return m;
        } else {
            int m = 36 - p.getPosition();
            return m;
        }
    }

}
