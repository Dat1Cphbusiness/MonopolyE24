public class Tax extends Field {
    public Tax(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }
    @Override
    public String onLand(Player p) {
        String s = super.onLand(p) + "\n Vil du betale fast beløb på" + this.cost + "kr? Tast J for ja \n ( ellers trækker  vi et beløb der svarer til 10% af dine aktiver)";
        return s;
    }

    @Override
    protected String onAccept(Player p) {
        Player.pay(this.cost) + "Du har betalt " + this.cost + "kr";
        return super.onAccept(p);
    }


    @Override
    protected String onReject(Player p) {
       double percentage = p.getWorhInCash(p) * 0.10;
       p.pay(percentage);
       return super.onReject(p) + " Du har betalt " + percentage +"af dine aktiver i skat";
    }
}
