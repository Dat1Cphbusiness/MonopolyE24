
public class Property extends Field{

    private int serieID;

    public Property(String label, int id, int income, int cost, int serieID){
        super(id, label, income, cost);
        this.serieID = serieID;
    }

    @Override
    public String onLand(Player p){
        return super.onLand(p);
    }

    @Override
    protected String onAccept(Player p){
        return null;
    }

    @Override
    protected String onReject(Player p) {
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + serieID;
    }
}