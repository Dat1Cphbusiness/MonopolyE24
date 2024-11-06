public class Dice {
    private int dice1 = rollDice();
    private int dice2 = rollDice();
    TextUI ui = new TextUI();

    public int getDice2() {
        return dice2;
    }   // end getDice2()

    public int getDice1() {
        return dice1;
    }   // end getDice1()

    private int rollDice() {
        int result = (int) (Math.random() * 6) + 1;

        while (result == 7 ||
               result == 0) {
            result = (int) (Math.random() * 6) + 1;
        }   // end while-loop

        return result;
    }   // end rollDice()

    public int roll(){
        int totalDiceEyes = dice1 + dice2;

        ui.displayMsg("You have rolled: " + dice1 +" + " + dice2 + " = " + totalDiceEyes);   // calling displayMsg from our TextUI class & typecasting totalDiceEyes
        return totalDiceEyes;
    }   // end roll()

    public boolean rollPrison(){
        dice1 = rollDice();
        dice2 = rollDice();
        boolean result = false;

            System.out.println(dice1 + "\n" + dice2);
            if (dice1 == dice2){
                // You get your freedom back
                ui.displayMsg("You have earned your freedom!");
                result = true;
            } else {
                // You need to stay in prison
                ui.displayMsg("You still have to stay in prison! I'd be productive to think about why you're here");
                result = false;
            }   // end  if-else statement

        return result;
    }   // end rollPrison()

}   // end Dice