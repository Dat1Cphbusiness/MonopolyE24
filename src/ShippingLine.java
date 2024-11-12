
public class ShippingLine extends Property{

        public ShippingLine(int id, String label, int income, int cost, int serieID){

            super(id, label, income, cost, serieID);

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
