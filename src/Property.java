
public class Property extends Field {

    private int serieID;

    public Property(String label, int id, int income, int cost, int serieID){
        super(id, label, income, cost);
        this.serieID = serieID;
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
        return null;
    }

    @Override
    protected String onReject(Player p) {
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + seriesID;
    }
}