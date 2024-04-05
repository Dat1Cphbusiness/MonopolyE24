import java.util.ArrayList;

public class Board {
    private Field[] fields;
    private ArrayList<Property> listOfpropertyFields;

    public Board(String[] data) {
        fields = new Field[40];
        createFields(data);
        this.listOfpropertyFields = new ArrayList<Property>();
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
                    f = new Start(id, label, income, cost);
                    break;
                case "Shipping Line":
                    f = new ShippingLine(id, label, income, cost, seriesID);
                    break;
                case "Plot":
                    f = new Plot(id, label, income, cost, seriesID);
                    break;
                case "Tax":
                    f = new Tax(id, label, income, cost);
                    break;
                case "Visit":
                    f = new Visit(id, label, income, cost);
                    break;
                case "Parkering":
                    f = new Parkering(id, label, income, cost);
                    break;
                case "Brewery":
                    f = new Brewery(id, label, income, cost, seriesID);
                    break;
                case "Prison":
                    f = new Prison(id, label, income, cost);
                    break;
                default: f = new Field(id, label, cost, income);
            }
            if (f instanceof Property) {
                this.listOfpropertyFields.add(f);
            }
        }
    }
     public Field getField(int i) {
        return fields[i-1];
     }
}
