public class Plot extends Property{

    public Plot(int id, String label, int cost, int income, int serieID){ // income og cost skal bytte plads så det passer med rækkefølgen i data
        super(id, label, cost, income, serieID);
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
