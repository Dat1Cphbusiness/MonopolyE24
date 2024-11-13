public class Tax extends Field {


    public Tax(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }
    @Override
    public String onLand(Player p) {
        String s = super.onLand(p) + "\n Vil du betale fast beløb på" + this.cost+ "kr.? Tast Y for ja \n (Ellers trækker vi et beløb der svarer til 10% af dine aktiver)";
        return s;
    }

    @Override
    protected String onAccept(Player p) {
        p.pay(cost);
        return p.getName() + " har accepteret og betalt et fast beløb på " + this.cost+  "kr.";
    }

    @Override
    protected String onReject(Player p) {
    return p.getName() + " har afvist, og vi trækker derfor 10% af aktiverne, som i alt bliver " + (p.getWorthInCash(p)*0.1) +"kr.";
    }
}
