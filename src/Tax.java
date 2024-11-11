public class Tax extends Field {

    public Tax(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }

    public String onLand(Player p) {
        String msg = super.onLand(p);
        return msg;
    }

    public String  onAccept(Player p) {
        return null;
    }

    protected String onReject(Player p) {
        return null;
    }
}
