public class ShippingLine extends Property{
    public ShippingLine (int ID, String label, int cost, int income, int serieID) {
            super(ID, label, cost, income, serieID);
        }

        @Override
        public String onLand (Player p){

        return super.onLand(p);
        }
    }


