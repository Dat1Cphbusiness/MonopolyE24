
public class ShippingLine extends Property{

        public ShippingLine(int seriesID, int ID, String label, int cost, int income){

            super(seriesID, ID, label, income, cost);

        }
    public String onLand(Player p){
        return super.onLand(p);

    }

    protected String onAccept(Player p){
        return null;
    }

    protected String onReject(Player p){
        return null;
    }
}
