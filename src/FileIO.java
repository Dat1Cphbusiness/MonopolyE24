import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public ArrayList<String> readPlayerData(String path){

        ArrayList<String> data = new ArrayList<>();

        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

        while(scan.hasNextLine()){
            String line = scan.nextLine();//"Tess, 2000"
            data.add(line);//

          /*  String[] values= line.split(",");
            String name = values[0];
            int balance = Integer.parseInt(values[1].trim());
            game.createPlayer(name,balance);*/

        }

    }catch(FileNotFoundException e){
        System.out.println("File was not found");
    }

     return data;
    }


    public static void saveData(ArrayList<Player> players, String path) {


        try {
            FileWriter writer = new FileWriter(path);
            writer.write("Name, Balance\n"); //Giv csv filen en header
            for (Player c: players) {
                writer.write(c+"\n"); //"Tess, 40000";
            }
            writer.close();
        }catch (IOException e){

        }
    }
}
