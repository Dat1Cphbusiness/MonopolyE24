public class Plot extends Property{
    public Plot(int id, String label, int cost, int income, int seriesID) {
        super(id, label, cost, income, seriesID);
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
