public class Brewery extends Property{

    public Brewery(String label, int id, int cost, int income) {
        super(label, id, cost, income);
    }

    @Override
    public String onLand(Player p){
        return super.onLand();
    }
}