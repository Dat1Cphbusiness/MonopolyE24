import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    public static ArrayList<String> readData(String path) {
        ArrayList<String> data = new ArrayList();
        File file = new File(path); // creates an instance of the File object with the path½
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

            while(scan.hasNextLine()){
                String line = scan.nextLine();                      // "tess, 40000"
                data.add(line);
            }   // end while

        }catch(FileNotFoundException e){
            System.out.println("File was not found");
        }   // end try-catch
        return data;
    }   // end readData()

    public static void saveData(List<String> items, String path, String header) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(header+"\n");                        //Give csv file a header
            for (String str: items) {
                writer.write(str+"\n");                       //"Tess, 40000";
            }   // end for-each
            
            writer.close();
        }catch (IOException e){
            System.out.println("something went wrong when writing to file");
        }   // end try-catch
    }   // end saveData()
}   // end FileIO
