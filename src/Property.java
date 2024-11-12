
public class Property extends Field{

    private int serieID;
    private Player owner;

    public Property(int id, String label, int income, int cost, int serieID){
        super(id, label, income, cost);
        this.serieID = serieID;
    }

    @Override
    public String onLand(Player p){

        String msg = super.onLand(p);
        if(owner == null){
            super.option = "buy";
            msg += "Vil du købe? (Y/N):";
        }
        else{
            if(p != owner){
                super.option = "payRent";
                msg += "Du skal betale "+super.income+". tast Y for at acceptere:";
            }


        }

        return msg;
    }
}