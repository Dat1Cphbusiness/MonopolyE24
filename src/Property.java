
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

    protected String onAccept(Player p){
        if(option.equals("buy")){
            p.buyProperty();
            p = owner;
        }
        String msg = p.getName() + " has bought " + label;
        return msg;
    }

    @Override
    protected String onReject(Player p) {

        if(option.equals("buy")){
            String msg = p.getName() + " afviste købstilbude. Auktion? " + label;
            return msg;
        }
        else if (option.equals("build")){
            String msg = p.getName() + " afviste at bygge" + label;
            return msg;
        }
        else{
            return null;
        }
    }

    @Override
    public String toString() {
        return super.toString() + seriesID;
    }
}