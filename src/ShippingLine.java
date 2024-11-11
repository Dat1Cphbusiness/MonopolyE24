
public class ShippingLine extends Property{

        public ShippingLine(String label, int id, int income, int cost, int serieID){

            super(label, id, income, cost, serieID);

        }
    public String onLand(Player p){
        return super.onLand(p);
    }
}
