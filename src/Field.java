public class Field {
    private String label;
    protected int id;
    protected int cost;
    protected int income;
    private String option;

    public Field(int id, String label, int cost, int income) {
        this.label = label;
        this.id = id;
        this.cost = cost;
        this.income = income;
    }

    public String onLand(Player p){
        return p.getName() + "has landed on" + label;
    }

    public String processResponse(Player p){
        return null;
    }

    protected String onAccept(Player p){
        return null;
    }

    protected String onReject(Player p){
    return null;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
