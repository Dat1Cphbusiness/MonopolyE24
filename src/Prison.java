public class Prison extends Field{

    public Prison(int ID, String label, int cost, int income){
        super(ID, label, cost, income);
    }

    public String onLand(Player p){
        return super.onLand(p);

    }

    protected String onAccept(Player p){
        return null;
    }

    protected String onReject(Player p){
        return null;
    }
}
