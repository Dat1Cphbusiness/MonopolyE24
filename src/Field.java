public class Field {
    protected String label;
    protected int id;
    protected int cost;
    protected int income;
    protected String option;

    public Field(int id, String label, int income, int cost) {
        this.label = label;
        this.id = id;
        this.cost = cost;
        this.income = income;
    }


    public String onLand(Player p){
        return p.getName() + "has landed on" + label;
    }

    public String processResponse(Player p,Boolean response){
       if(response == true){
           return this.onAccept(p);
       } else if (response == false) {
           return this.onReject(p);
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
