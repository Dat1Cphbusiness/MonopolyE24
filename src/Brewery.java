public class Brewery extends Plot{
    public Brewery(int serieId, int id, String label, int cost, int income) {
        super(serieId, id, label, cost, income);
    }

    @Override
    public String onLand(Player p){
        return super.onLand(p);
    }
}
