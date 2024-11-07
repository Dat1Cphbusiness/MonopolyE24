public class Property extends Field{
    private int serieID;
    public Property(int serieID, int id, String label, int cost, int income){
        super(id, label, cost, income);
        this.serieID = serieID;
    }

    @Override
    public String toString() {
        return super.toString() + serieID;
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
    protected String onReject(Player p){
        return null;
    }
}
