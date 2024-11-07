public class Field {
    private String label;
    private int id;
    private int cost;
    private int income;
    private String option;

    public Field(String label, int id, int cost) {
        this.label = label;
        this.id = id;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Field{" + "id=" + id + ", label='" + label + '\'' + '}';
    }
    public String onLand(Player p){
        return (p.getName() + "has landed on field " + "felt ikke lavet i nu");
    }
}
