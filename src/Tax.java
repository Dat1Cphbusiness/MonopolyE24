public class Tax extends Field {
    public Tax(int id, String label, int cost, int income) {

        super(id, label, cost, income);
    }
    @Override
    public String onLand(Player p) {
        String s = super.onLand(p);
        s += "\n Vil du betale fast beløb på " + this.cost + "kr? Tast Y for ja \n (Ellers trækker vi et beløb der svarer til 10% af dine aktiver");
        return s;
    }

    @Override
    protected String onAccept(Player p) {
    // p.pay(this.cost);
    return super.onAccept(p);
    }

    @Override
    protected String onReject(Player p) {
    String s = "Du har valgt at betale på 10% af alle dine aktiver: " + p.getTotalWorth(); + "og skal betale: "  + p.pay(result);
    s += super.onReject(p);
        return s;
    }
}
