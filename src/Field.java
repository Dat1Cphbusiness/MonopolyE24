public class Field {
    private int ID;
    private String label;
    private int cost;
    private int income;
    protected String option;

    public Field(int id, String label, int cost, int income) {
        this.ID = id;
        this.label = label;
        this.cost = cost;
        this.income = income;
    }

    public String processResponse(String response, Player p) {
        if (response.equalsIgnoreCase("Y")) {
            onAccept(p);
        } else if (response.equalsIgnoreCase("N")) {
            onReject(p);
        } else {
            System.out.println("Invalid input");
            processResponse(response, p);
        }
        return "";
    }

    @Override
    public String toString() {
        return "felt " + ID + ": " + label;
    }


    public String onLand(Player p) {
        String s = p.getName() + " er landet på " + this.toString();
        return s;
    }

    public String processResponse(Player p) {
        return "";
    }

    protected String onAccept(Player p) {
        return "";
    }

    protected String onReject(Player p) {
        return "";
    }

    public String getLabel() {
        return label;
    }

    public int getIncome() {
        return income;
    }
}