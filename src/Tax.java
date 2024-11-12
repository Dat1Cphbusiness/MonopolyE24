public class Tax extends Field {
    public Tax(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }
    @Override
    public String onLand(Player p) {
        String s = super.onLand(p);
        s+="\n Vil du betale fast beløb på "+this.cost+"kr? Tast J for ja \n (Ellers trækker vi et beløb der svarer til 10% af dine aktiver)";
        return s;
    }

    @Override
    protected String onAccept(Player p) {
       int amountPaid = p.pay(this.cost);

       return "Player" + p.getName() + " har valgt at betale et fast beløb og har betalt " + amountPaid + " kr." + super.onAccept(p);

    }

    @Override
    protected String onReject(Player p) {
        int amountToPay = (p.getWorthInCash()*0.1);
        int amountPaid = p.pay(amountToPay);
        return p.getName()+ " har valgt at betale med 10% af sine aktiver som svarer til " + amountPaid + " kr." + super.onReject(p);
    }
}
