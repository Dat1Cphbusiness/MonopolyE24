
public class ShippingLine extends Property{

        public ShippingLine(String label, int id, int income, int cost, int serieID){

            super(label, id, income, cost, serieID);

        }
    @Override
    public String onLand(Player p) {
        return super.onLand(p);
    }

    @Override
    protected String onAccept(Player p) {
        return super.onAccept(p);
    }

    @Override
    protected String onReject(Player p) {
        return super.onReject(p);
    }
}
