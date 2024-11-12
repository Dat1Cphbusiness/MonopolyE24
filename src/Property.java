
public class Property extends Field {

    private int seriesID;
    private Player owner;

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
        return msg;
    }


    @Override
    protected String onAccept(Player p) {
        if("buy".equalsIgnoreCase(option)) {
            Player.buyProperty(p);
            owner = p;
            return p.getName() + " købte " + this.label ;}
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
}