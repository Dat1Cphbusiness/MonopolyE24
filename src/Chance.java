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


        //Da der ikke findes der kort som giver spilleren en valgmulighed, bør vi bare kalde onAccept herfra. Evt. omnavngiv til 'executeEvent()'
         s=s+ "\n"+onAccept(p);
        return s;
    }

    @Override
    public String toString() {
        return card.getMessage()+"," + event ;
    }



    protected String onAccept(Player p) {
        String eventSpecificMsg = "";
        switch (event) {
            case "pay":
                p.pay(card.getCost());
                eventSpecificMsg = " har betalt "+card.getCost()+"kr";
                break;
            case "reward":
                p.receive(card.getIncome());
                eventSpecificMsg = " har modtaget "+card.getIncome()+"kr";
                break;
            case "rewardFromPlayers":
                // todo: få fat i listen af spillere fra Game.
                //  Gennemløb listen og send penge fra alle spillere (som ikke er p) til p
                //  otherplayer.pay(card.getIncome(), p);
                eventSpecificMsg = " har modtaget betaling fra alle de andre";
                break;
            case "prison":
                p.moveToPrison();
                eventSpecificMsg =" er røget i fængsel";
                break;


            case "moveToFerry":
                //todo skal testes
                int nearestFerryPosition = nearestFerry(p);

                p.setPaymentTimes(2);//sørger for at betalingen bliver dobbelt, hvis færgen ejes af en anden spiller

                moveToPosition(nearestFerryPosition, p);
               // Main.games.get(0).throwAndMove();//vi kalder i stedet landAndAct med feltet
                Field f = Main.games.get(0).board.getField(nearestFerryPosition);
                Main.games.get(0).landAndAct(f);


                p.setPaymentTimes(1);// reset betaling til normal

                break;

/* dobbeltkonfekt? Vi sætter paymentTimes i 'moveToFerry-casen. ( Burde være ok, hvis det med dobbeltbetaling kun sker når man rykker til en færge?)

            case "doubleRentPaymentToPlayer":

                int a = nearestFarry(p);
                p.setPaymentTimes(2);
                p.setDestination(a);
                Main.games.get(0).throwAndMove();
                p.setDestination(0);
                p.setPaymentTimes(1);
                break;
*/
            case "moveTo":
                //Vi har refaktoret beregningen ud i egen metode, moveToPosition.
                int newPosition = card.getMoveToPosition();
                moveToPosition(newPosition, p);
                eventSpecificMsg = " blev rykket til "+ newPosition;
                break;
            }
        // vi gør beskeden mere specifik så den afspejler den event der lige er sket
        return " " + p.getName() + eventSpecificMsg;
            // todo: hvordan kan vi håndtere at der er trukket et kort der giver imunitet overfor fængsling?
            //  Skal Player klassen have boolean attribut (et flag) der viser om man har et wildcard? Hvor skal dette flag tjekkes henne, så man ikke ryger i fængsel hvis man har wildcard?
        }

        //todo: Skal testes. denne metode bør nok ligge i Player klassen
    private void moveToPosition(int newPosition, Player p) {
        if (p.getPosition() <newPosition ) {
            int m = newPosition - p.getPosition();
            p.setDestination(m);
            Main.games.get(0).throwAndMove();
            p.setDestination(0);
        } else {
            int m = Math.abs(p.getPosition() - 40) + newPosition;
            p.setDestination(m);
            Main.games.get(0).throwAndMove();
            p.setDestination(0);
        }
    }


    protected String onReject (Player p){
        return "Spiller " + p.getName() + " afviste tilbuddet.";
        }

    public int nearestFerry(Player p) {

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
