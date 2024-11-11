public class ShippingLine extends Property {

    public ShippingLine(String label, int id, int cost, int income) {
        super(label, id, cost, income);
    }

    @Override
    public String onLand(Player p){
        return super.onLand();
    }
}
