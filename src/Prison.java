public class Prison extends Field{
    public Prison(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }

    @Override
    public String onLand(Player p) {
        return super.onLand(p);
    }
}
