public class Property extends Field {
    private int serieID;
    private Player owner;

    public Property(int id, String label, int cost, int income, int serieID) {
        super(id, label, cost, income);
        this.serieID = serieID;

    }

    @Override
    public String toString() {
        return super.toString() + serieID;
    }

    @Override
    public String onLand(Player p) {
        String msg = super.onLand(p);
        if(owner == null){
            this.option  = "buy";
            msg += "Vil du købe " + super.getLabel() + "? (Y/N)";
        }else if(owner != p){
            this.option = "payRent";
            msg += "Du skal betale " + super.getIncome() + ". Indforstået Y/N";
        }
        return msg;
    }

    @Override
    protected String onAccept(Player p) {
        if (this.option.equalsIgnoreCase("buy")){
            System.out.println("Du har mulighed for at købe "+ getLabel()+ ".");
            p.buyProperty();
        }else if (this.option.equalsIgnoreCase("payRent")){
            System.out.println("Du skal betale husleje til ejeren af "+ getLabel() + "."); //Evt ændre fra label til ejer af "Deed"
            p.pay();
        }
        return null;
    }

    @Override
    protected String onReject(Player p) {
        return "";
    }
}






