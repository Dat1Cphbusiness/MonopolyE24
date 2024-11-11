public class Field {
    private String label;
    private int id;
    private int cost;
    private int income;
    private String option;

    public Field(String label, int id, int cost, int income) {
        this.label = label;
        this.id = id;
        this.cost = cost;
        this.income = income;
    }

    public String processResponse (Player p){
        return "";
    }

    protected String onAccept(Player p){
        return "";
    }

    protected String onReject(Player p){
        return "";
    }


    @Override
    public String toString() {
        return "Field{" + "id=" + id + ", label='" + label + '\'' + '}';
    }

    public String onLand(Player p){
        return (p.getName() + "has landed on field " + id + ", " + label);
    }

}
