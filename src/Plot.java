public class Plot extends Property{

    public Plot(int seriesID, int ID, String label, int cost, int income){
        super(seriesID, ID, label, cost, income);
    }


    @Override
    public String onLand(Player p){
        return super.onLand(p);
    }

    public String processResponse(Player p){
        return null;
    }

    protected String onAccept(Player p){
        return null;
    }

    protected String onReject(Player p){
        return null;
    }

}
