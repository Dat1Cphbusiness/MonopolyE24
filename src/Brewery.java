public class Brewery extends Property{

    public Brewery(int id, String label, int income, int cost, int serieID){

        super(label, id, income, cost, serieID);
    }

    public String onLand(Player p){
        return super.onLand(p);
    }
}
