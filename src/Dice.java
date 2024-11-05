public class Dice {

    public int roll(){
        TextUI ui = new TextUI();
        int totalDiceEyes;
        double tmp = 0.0;

        for (int i = 0; i < 2; i++) {       // runs code 2 times
            tmp += (Math.random()*6)+1;
        }   // end for-loop

        totalDiceEyes = (int) tmp;          // typecasts from double to int
        ui.displayMsg("You have rolled" + totalDiceEyes);
        return totalDiceEyes;
    }   // end roll()
}   // end Dice