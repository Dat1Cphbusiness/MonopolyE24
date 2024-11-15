
public class Property extends Field {

    private int seriesID;
    private Player owner;

    //todo: tilføj en metode hasMonopoly(), der gennemløber alle propertyfields i boardklassen (kræver at vi gør propertyfields static)
    // for hvert Property felt, tjekkes om det har samme serieID som this
    // og om det er currentPlayer (p) der ejer det.


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
        }//todo: her kan vi tjekke om spilleren både ejer feltet OG de andre felter i serien (har monopol)
         // Se ovenfor om tilføjelse af en hasMonopoly metode
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

    public boolean hasMonopoly(Player currentPlayer){
        boolean hasMonopoly = false;
            for (Property other: Board.propertyfields) {
            if(this.seriesID == other.seriesID) {
                if(currentPlayer.equals(other.owner)){
                    hasMonopoly = true;
                }else{
                    return false;
                }
            }
            // else do nothing
            }
        return hasMonopoly;
    }

}