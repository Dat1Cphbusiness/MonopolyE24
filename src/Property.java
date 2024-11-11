public class Property extends Field{
    private Player owner;
    private int seriesID;

    public Property(int seriesID, int ID, String label, int cost, int income){
        super(ID, label, cost, income);
        this.seriesID = seriesID;
    }

    public String toString(){
        return super.toString() + "\nSerie ID: " + seriesID;
    }

    public String onLand(Player p){
        String msg = super.onLand(p);

        if (owner == null){// True condition
            option = "buy";
            msg += "Vil du købe? (Y/N)";

        }
        else if(owner != null && owner != p) { // False condition
           msg+= "Du skal betale " + income + ". Tast Y for at acceptere:";

        }
        return msg;
    }



}
