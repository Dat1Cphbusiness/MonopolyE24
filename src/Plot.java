public class Plot extends Property{

    public Plot(String label, int id, int income, int cost, int serieID){
        super(label, id, income, cost, serieID);
    }


    @Override
    public String onLand(Player p){
        return super.onLand(p);
    }

}