public class Property extends Field {
    private int serieID;
    private Player owner;

    public Property(int id, String label, int cost, int income, int serieID) {
        super(id, label, cost, income);
        this.serieID = serieID;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String onLand(Player p) {
        String msg = super.onLand(p);
        if(owner == null){
            this.option  = "buy";
            msg += "\nVil du købe " + super.getLabel() + "? (Y/N)";
        }else if(owner != p){
            this.option = "payRent";
            msg += "\nDu skal betale " + super.getIncome() + ". Indforstået Y/N";
        }
        return msg;
    }

    @Override
    protected String onAccept(Player p) {
        String msg = "";
        if (this.option.equalsIgnoreCase("buy")){
            msg = "Du har købt "+this.getLabel();
            p.buyProperty(this);
            this.owner = p;

        }else if (this.option.equalsIgnoreCase("payRent")){
            msg ="Du har betalt til "+this.owner; //Evt ændre fra label til ejer af "Deed"
            p.pay(this.getIncome(),owner);
        }
        return msg;
    }

    @Override
    protected String onReject(Player p) {
        return "";
    }
}






