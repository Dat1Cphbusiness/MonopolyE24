public class Tax extends Field {
    public Tax(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }
    @Override
    public String onLand(Player p) {
        String msg = super.onLand(p);
        msg += "\nSkat trækker et beløb der svarer til 10 % af dine aktiver. \n" +
                "Vil du hellere betale fast beløb på " + this.cost + "kr? Y/N";
        return msg;

    }

    @Override
    protected String onAccept(Player p) {
        String msg = "";
        p.pay(this.cost);
        msg += "\nDu har betalt "+this.cost+"kr i skat.";
        return msg;
    }

    @Override
    protected String onReject(Player p) {
        int tax = (p.getBalance()/10);
        p.pay(tax);
        String msg = "Du har betalt " + tax + "kr i skat";
        return msg;
    }
}
