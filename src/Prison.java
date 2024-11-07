public class Prison extends Dice {
    // Attributes
    private int prisonTimeCounter;
    private boolean inHotel = false;

    public Prison(int timeLeftInHotel) {
        super();
        this.prisonTimeCounter = timeLeftInHotel;
        inHotel = true;
    }   // end Constructor

    public Prison() {
        super();
        if (inHotel == true) {
            prisonTimeCounter--;  // decrease the roundCounter by 1
            // skip turn
        } else {
            // give user a turn
        }   // end if-else statement
    }   // end Constructor


    public int getPrisonTimeCounter() {
        return this.prisonTimeCounter;
    }   // end getTimeLeftInHotel()

    public boolean getOut(){

        if (new Dice().rollPrison()) {
            // get out of prison
            inHotel = false;
            System.out.println("You get to go home");
            return true;    // Either or not in still in prison
        } else {
            // Stay in prison
            prisonTimeCounter--;
            inHotel = true;
            System.out.println("Still in the hotel");
            return false;   // Either or not in still in prison
        }   // end if-else statement
    }   //  end getOut
}   // end Prison
