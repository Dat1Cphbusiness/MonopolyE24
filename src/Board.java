import java.util.List;

public class Board {
    private Field[] fields;
    private CardDeck cardDeck;
    private List<Field> propertyFields;

    public Board(String[] fielddata, String[] carddata){
        createFields(fielddata);
        this.cardDeck = new CardDeck(carddata);
    }

    private void createFields(String[] data){
        fields = new Field[data.length];
        for (int i = 0; i < data.length; i++){
            String[] values = data[i].split(",");
            int id = Integer.parseInt(values[0].trim());
            String fieldType = values[1].trim();
            String label = values[2].trim();
            int cost = Integer.parseInt(values[3].trim());
            int income = Integer.parseInt(values[4].trim());
            int seriesID = Integer.parseInt(values[5].trim());
            fields[i] = null;

            switch (fieldType) {
                case "Start":
                    fields[i] = new Start(id, label, income, cost, seriesID);
                    break;
                case "Plot":
                    fields[i] = new Plot(id, label, income, cost, seriesID);
                    propertyFields.add(fields[i]);
                    break;
                case "Chance":
                    fields[i] = new Chance(id, label, income, cost, seriesID, cardDeck);
                    break;
                case "Tax":
                    fields[i] = new Tax(id, label, income, cost, seriesID);
                    break;
                case "ShippingLine":
                    fields[i] = new ShippingLine(id, label, income, cost, seriesID);
                    propertyFields.add(fields[i]);
                    break;
                case "Visit":
                    fields[i] = new Visit(id, label, income, cost, seriesID);
                    break;
                case "Brewery":
                    fields[i] = new Brewery(id, label, income, cost, seriesID);
                    propertyFields.add(fields[i]);
                    break;
                case "Parking":
                    fields[i] = new Parking(id, label, income, cost, seriesID);
                    break;
                case "Prison":
                    fields[i] = new Prison(id, label, income, cost, seriesID);
                    break;
                default: System.out.println("No such type is available");
            }
        }
    }

    public Field getField(int id){
        return fields[id-1];
    }
}
