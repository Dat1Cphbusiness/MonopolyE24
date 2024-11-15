import java.util.ArrayList;

public class Property extends Field {

    private int seriesID;
    private Player owner;

    //todo: tilføj en metode hasMonopoly(), der gennemløber alle propertyfields i boardklassen (kræver at vi gør propertyfields static)
    // for hvert Property felt, tjekkes om det har samme serieID som this
    // og om det er currentPlayer (p) der ejer det.

    public boolean hasMonopoly(Player CurrentPlayer){

        int ownership = 0;

        for(Field propertyF : CurrentPlayer.deeds){
                Property p = (Property) propertyF;
                if(p.getSeriesID() == this.seriesID){
                    if (CurrentPlayer == p.getOwner()){
                        ownership++;
                    }
                    else{
                        return false;
                    }

                }
        }
        //value for how many cards are in a series for monopoly
        int checkingValue = 3;
        //switch case for if the checking value has to change
        //in cases where the amount of cards in a set is a different value from the default 3
        switch (this.seriesID){
            case 1:
            case 9:
                checkingValue = 2;
                break;
            case 2:
                checkingValue = 4;
                break;
        }
        //checks if the player owns all cards in a series
        if (ownership == checkingValue){
            return true;
        }
        else{
            return false;
        }

    }

    public Property(int id, String label, int income, int cost, int seriesID) {
        super(id, label, income, cost);
        this.seriesID = seriesID;

    }

    @Override
    public String onLand(Player p) {

        String msg = super.onLand(p);
        if (owner == null) {
            option = "buy";
            msg += "Vil du købe? (Y/N): ";
        } else if (owner != null && owner != p) {
            msg += "Du skal betale " + income + ". Tast Y for at acceptere";
        }
        //todo: implementer logik for de funktioner man kan gøre i tilfælde af monopol
        else if (hasMonopoly(p)){
            msg += p.getName() + "har monopol!";
        }
        return msg;
    }


    @Override
    protected String onAccept(Player p) {
        if("buy".equalsIgnoreCase(option)) {
            p.buyProperty(this);
            owner = p;
            return p.getName() + " købte " + this.label ;
        }
//            else if ("build".equalsIgnoreCase(option)){
//            Player.buildHouse();
//            return p.getName() + " byggede på " + this.label ;
//        }
        return "-1";
    }

    @Override
    protected String onReject(Player p) {
        if ("buy".equalsIgnoreCase(option))  {
            return p.getName() + " afviste købstilbud. Auktion?";
        }else if ("build".equalsIgnoreCase(option)){
            return p.getName() + " afviste at bygge";
        }
        return "-1";
    }

    @Override
    public String toString() {
        return super.toString() + seriesID;
    }

    public int getSeriesID() {
        return seriesID;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}