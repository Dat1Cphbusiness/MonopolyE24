import java.util.ArrayList;

public class Board {
    private Field[] fields;
    private CardDeck cardDeck;
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
                    f = new Chance(label, id, income, cost,cardDeck); // cardDeck skal måske fjernes
                    break;
                case " Start":
                    f = new Start(label, id, income, cost);
                    break;
                case "Plot":
                    f = new Plot(label, id, income, cost, serieID);
                    propertyfields.add(f);
                    break;
                case "Brewery":
                    f = new Brewery(label, id, income, cost, serieID);
                    propertyfields.add(f);
                    break;
                case "Shipping line":
                    f = new ShippingLine(label, id, income, cost, serieID);
                    propertyfields.add(f);
                    break;
                case "Tax":
                    f = new Tax(label, id, income, cost);
                    break;
                case "Prison":
                    f = new Prison(label, id, income, cost);
                    break;

                default:
                    System.out.println("Invalid field type");
                    break;
            }
            fields[i] = f;
        }

    }

    public Field getField(int id) {
        return fields[id - 1];
    }

}
