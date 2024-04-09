import java.util.ArrayList;

public class Board {

    private Field[] fields;
    private ArrayList<Property> listOfpropertyFields;



    public Board(String[] data) {
        fields = new Field[40];
        this.listOfpropertyFields = new ArrayList<Property>();
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


            Field f = null;

            switch (fieldType)
            {
                case "Chance":
                   f = new Chance(id, label, income, cost);
                    break;
                case "Start":
                    f = new Start(id, label,  cost, income);
                    break;
                case "ShippingLine":
                    f = new ShippingLine(id, label,  cost, income, seriesID);
                    break;
                case "Plot":
                    f = new Plot(id, label, cost, income, seriesID);
                    break;
                case "Tax":
                    f = new Tax(id, label,  cost, income);
                    break;
                case "Visit":
                    f = new Visit(id, label,  cost, income);
                    break;
                case "Parkering":
                    f = new Parking(id, label,  cost, income);
                    break;
                case "Brewery":
                    f = new Brewery(id, label, cost, income, seriesID);
                    break;
                case "Prison":
                    f = new Prison(id, label, cost, income);
                    break;
                default: f = new Field(id, label, cost, income);
            }

            if (f instanceof Property) {
                Property p = (Property)f;
                this.listOfpropertyFields.add(p);
            }

            fields[i] = f;
        }
    }
     public Field getField(int i) {
        return fields[i-1];
     }


}
