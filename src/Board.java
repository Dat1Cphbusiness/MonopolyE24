import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    private Field[] fields;

    public Board(String[] data) {
        fields = new Field[40];
        createFields(data);
    }

    private void createFields(String[] data){
        for(int i = 0;i<data.length;i++){
            String[] values = data[i].split(",");
            int id = Integer.parseInt(values[0].trim());
            String fieldType = values[1].trim();
            String label = values[2].trim();
            int cost = Integer.parseInt(values[3].trim());
            int income = Integer.parseInt(values[4].trim());
            int seriesID = Integer.parseInt(values[5].trim());


            this.fields[i] = new Field(id, label, cost, income);
        }
    }
     public Field getField(int i) {
        return fields[i-1];
     }
}
