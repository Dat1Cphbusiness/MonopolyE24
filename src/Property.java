public class Property extends Field{
    private int serieID;
    public Property(int id, String label, int cost, int income, int serieID) {
        super(id, label, cost, income);
        this.serieID = serieID;

    }


}

