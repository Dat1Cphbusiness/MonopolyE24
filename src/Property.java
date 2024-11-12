
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