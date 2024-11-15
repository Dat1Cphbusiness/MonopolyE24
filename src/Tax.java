public class Tax extends Field {


    public Tax(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }


    @Override
    public String onLand(Player p) {
        String s = null;

        if (id == 5) {
            this.option = "payFixedOrPercentage";
            s = super.onLand(p) + "\n Vil du betale fast beløb på " + this.cost + "kr.? Tast Y for ja \n (Ellers trækker vi et beløb der svarer til 10% af dine aktiver)";
            return s;
        } else if (id == 39) {
            this.option = null;
            s = super.onLand(p) + "\n Du skal betale et fast beløb på " + this.cost + "kr.";
            p.pay(2000);
            return s;
        }
        return s;
    }

    @Override
    protected String onAccept(Player p) {
        p.pay(cost);
        return p.getName() + " har accepteret og betalt et fast beløb på " + this.cost+  "kr.";
    }
//todo: brug Player klassens getWorthInTotal() til at beregne skatten
    @Override
    protected String onReject(Player p) {
        double value = (p.getWorthInCash() * 0.1);
        p.pay((int) value);
        return p.getName() + " har afvist, og vi trækker derfor 10% af aktiverne, som i alt bliver " + value + "kr.";
    }
}
