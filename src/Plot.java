public class Plot extends Property{

    public Plot(int id, String label, int income, int cost, int serieID){
        super(id, label, income, cost, serieID);
    }


    @Override
    public String onLand(Player p){
        return super.onLand(p);
    }

}
