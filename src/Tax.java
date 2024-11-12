public class Tax extends Field {
    public Tax(int id, String label, int cost, int income) {
        super(id, label, cost, income);
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
