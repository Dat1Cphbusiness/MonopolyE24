    public class Plot extends Property{

        public Plot(String label, int id, int cost, int income) {
            super(label, id, cost, income);
        }

        @Override
        public String onLand(Player p){
            return super.onLand();
        }

    }
