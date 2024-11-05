import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    Scanner scan = new Scanner(System.in);  // userInput

    public ArrayList<String> promptChoice(ArrayList<String> options, int limit, String msg){
        ArrayList<String> choices = new ArrayList<String>();  //Lave en beholder til at gemme brugerens valg
        int count = 1;
        while(choices.size() < limit){             //tjekke om brugeren skal vælge flere drinks
            String choice = promptText(count+":");
            choices.add(choice);
            count++;
        }   // end while
        return choices;
    }   // end promptChoice

    public void displayList(ArrayList<String> options, String msg){
        /*
        This func takes an ArrayList<String> & String as parameters.
        The String is a message for the user & the ArrayList is printed & iterated.
         */
        System.out.println("*******");
        System.out.println(msg);    // message for the user
        System.out.println("*******");

        int i = 1;  // set i to 1 so the for-each loop starts at 1

        for (String option : options) {
            System.out.println(i + ": "+option); // prints a number based on each index of the ArrayList (index 1) & print the String for each index
            ++i;
        }   // end for-each loop
    }   // end displayList

    public String promptText(String msg){
        /*
        Func takes a String as a parameter & returns a String from userInput
         */
        System.out.println(msg);//Stille brugeren et spørgsmål
        String input = scan.nextLine(); // saves userInput in 'input' variable
        return input;   // returns
    }   // end promptText

    public int promptNumeric(String msg){
        /*
        Func takes a String as a parameter & returns an integer from userInput
         */
        System.out.println(msg);              // Stille brugeren et spørgsmål
        String input = scan.nextLine();       // Give brugere et sted at placere sit svar og vente på svaret
        int number = Integer.parseInt(input); // Konvertere svaret til et tal
        return number;
    }   // end PromptNumeric

    public void displayMsg(String msg){
        /*
        Displays a message which is the parameter for the func
         */
        System.out.println(msg);
    }   // end displayMsg
}   // end TextUI
