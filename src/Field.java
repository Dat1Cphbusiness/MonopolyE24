public class Field {
    protected String label;
    protected int id;
    protected int cost;
    protected int income;
    protected String option;

    public Field(int id, String label, int cost, int income) {
        this.label = label;
        this.id = id;
        this.cost = cost;
        this.income = income;
    }


    public String onLand(Player p){
        return p.getName() + "has landed on" + label;
    }

    public String processResponse(Player p,String response){
       if("Y".equalsIgnoreCase(response)){
           return onAccept(p);
       } else if ("N".equalsIgnoreCase(response)) {
           return onReject(p);
       }
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
        return "Field{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
