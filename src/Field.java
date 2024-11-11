public abstract class Field {
    private String label;
    private int ID;
    private int cost;
    private int income;
    private String option;

    public Field(int ID, String label, int cost, int income) {
        this.ID = ID;
        this.label = label;
        this.cost = cost;
        this.income = income;
    }

    @Override
    public String toString() {
        return "Field{" +
                "ID=" + ID +
                ", label='" + label + '\'' +
                '}';
    }

    public String onLand (Player p){
        String result = "";
        result += p.getName();
        result += " er landet på felt ";
        result += ID;
        result += ", ";
        result += label;
        return result;
    }
    public String processResponse(Player p){
        return processResponse(p);
    }

    protected String onAccept(Player p){
        return onAccept(p);
    }

    protected String onReject(Player p){
        return onReject(p);
    }
}
