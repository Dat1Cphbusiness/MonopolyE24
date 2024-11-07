
/** This example demonstrates the foundations of building an object-oriented system in Java.
 *  It uses the domain of a bank
 *
 *
 *  adHoc_object_creation branch demonstrates the following subjects and techniques:
 *     Bank class
 *    - using the Scanner with a while loop for user dialog
 *    - Scanner bug
 *
 *    Main class
 *    - condition to check state of an array
 *
 *
 *  THINGS TO CONSIDER
 *
 *    The user can now add customers to the bank.
 *    But only if the list of customer objects is empty
 *    what if we want the user to add customers at various times during the session?
 *    what about other actions, like adding money to a customer's account?
 *    How could this be achieved?
 *
 */


class Main {

    public static void main(String[] args) {
        Prison pri = new Prison();

        Game game = new Game("Matador");
        game.setup();    // reads the playerdata.csv file


        System.out.print(game + "\n");

        System.out.println("*******");
        System.out.println("prison: " +pri.rollPrison());
        System.out.println("*******");

        //String name = game.getPlayerByIndex(1).getName();
        //System.out.println("+ " +name);

        game.throwAndMove();
        game.endSession();  // writes to playerdata.csv file

        game.runGameLoop();
    }   // end  main()
}   // end Main