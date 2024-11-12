import java.util.ArrayList;

public class Board {
    private Field[] fields;
    public static CardDeck cardDeck;
    private ArrayList<Field> propertyfields  = new ArrayList<>();

    public Board(String[] fielddata, String[] carddata) {
        createFields(fielddata);
        this.cardDeck = new CardDeck(carddata);
    }

    private void createFields(String[] data) {
        fields = new Field[data.length];
        for (int i = 0; i < data.length; i++) {
            String[] values = data[i].split(",");
            int id = Integer.parseInt(values[0].trim());
            String label = values[2].trim();
            int cost = Integer.parseInt(values[3].trim());
            int income = Integer.parseInt(values[4].trim());
            int serieID = Integer.parseInt(values[5].trim());
            Field f = null;
            String fieldtype = values[1].trim();

            switch (fieldtype) {
                case "Chance":
                    f = new Chance(id, label, income, cost); // cardDeck skal måske fjernes
                    break;
                case "Start":
                    f = new Start( id, label, income, cost);
                    break;
                case "Plot":
                    f = new Plot(id, label, income, cost, serieID);
                    propertyfields.add(f);
                    break;
                case "Brewery":
                    f = new Brewery(id, label, income, cost, serieID);
                    propertyfields.add(f);
                    break;
                case "ShippingLine":
                    f = new ShippingLine(id, label, income, cost, serieID);
                    propertyfields.add(f);
                    break;
                case "Tax":
                    f = new Tax(id, label, income, cost);
                    break;
                case "Prison":
                    f = new Prison(id, label, income, cost);
                    break;
                case "Visit":
                    f = new Visit(id, label, income, cost);
                    break;
                case "Parking":
                    f = new Parking(id, label, income, cost);
                    break;

                default:
                    System.out.println("Invalid field type" + id);
                    break;
            }
            fields[i] = f;
        }

    }

    public Field getField(int id) {
        return fields[id - 1];
    }

}
