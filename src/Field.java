public abstract class Field {
    private String label;
    private int id;
    private int cost;
    private int income;
    private String option;

    public Field(int id, String label, int cost, int income){
        this.id = id;
        this.label = label;
        this.cost = cost;
        this.income = income;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }

    public String onLand(Player p){
        return p.getName() + " has landed on" + label + "field"; //Label is maybe filed name
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
}
