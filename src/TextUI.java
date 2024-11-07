

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    private Scanner scan = new Scanner(System.in);

    public void displayMsg(String msg){
        System.out.println(msg);
    }

    public int promptNumeric(String msg){
        System.out.println(msg);              // Stille brugeren et spørgsmål
        String input = scan.nextLine();       // Give brugere et sted at placere sit svar og vente på svaret
        int number = Integer.parseInt(input); // Konvertere svaret til et tal
        return number;
    }

    public String promptText(String msg){
        System.out.println(msg);//Stille brugeren et spørgsmål
        String input = scan.nextLine();
        return input;
    }

    public boolean promptBinary(String msg){
        String input = promptText(msg);
        boolean choice = false;
        if (input.equalsIgnoreCase("y")){
            choice = true;
        } else if (input.equalsIgnoreCase("n")) {
            choice = false;
        } else {
            System.out.println("Please enter Y or N");
            promptBinary(msg);
        }
        return choice;
    }

    public ArrayList<String> promptChoice(ArrayList<String> options, int limit, String msg){
        ArrayList<String> choices = new ArrayList<String>();  //Lave en beholder til at gemme brugerens valg
        int count = 1;
        while(choices.size() < limit){             //tjekke om brugeren skal vælge flere drinks
            String choice = promptText(count+":");
            choices.add(choice);
            count++;
        }
        return choices;
    }

    public void displayList(ArrayList<String> options, String msg){
        System.out.println("*******");
        System.out.println(msg);
        System.out.println("*******");

        int i = 1;

        for (String option : options) {
            System.out.println(i+": "+option);
            i++;
        }
    }
}
