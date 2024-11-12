
public class Property extends Field{

    private int serieID;

    public Property(String label, int id, int income, int cost, int serieID){
        super(id, label, income, cost);
        this.serieID = serieID;
    }

    @Override
    public String onLand(Player p){
        return super.onLand(p);
    }

    @Override
    protected String onAccept(Player p){
        switch (event){
            case "payment":
                currentPlayer.pay(msg, income, cost, event);
                System.out.println("You've lost" + cost + "\n");
                break;

            case "reward":
                currentPlayer.receive(msg, income, player);
                System.out.println(" has gained "+ income + "\n");
                break;

            case "prison":
                currentPlayer.mveToPrison(player);
                System.out.println( currentPlayer +" is going to prison\n");
                break;

            case "moveTo":
                currentPlayer(msg, income, cost)
                break;

            case "paymentPerProperty":
                currentPLayer
                break;
        }
    }

    @Override
    protected String onReject(Player p) {
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + serieID;
    }
}