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
            Field f = null;

            switch (fieldType) {
                case "Start":
                    f = new Start(id, label, income, cost, seriesID);
                    break;
                case "Plot":
                    f = new Plot(id, label, income, cost, seriesID);
                    propertyFields.add(f);
                    break;
                case "Chance":
                    f = new Chance(id, label, income, cost, seriesID, cardDeck);
                    break;
                case "Tax":
                    f = new Tax(id, label, income, cost, seriesID);
                    break;
                case "ShippingLine":
                    f = new ShippingLine(id, label, income, cost, seriesID);
                    propertyFields.add(f);
                    break;
                case "Visit":
                    f = new Visit(id, label, income, cost, seriesID);
                    break;
                case "Brewery":
                    f = new Brewery(id, label, income, cost, seriesID);
                    propertyFields.add(f);
                    break;
                case "Parking":
                    f = new Parking(id, label, income, cost, seriesID);
                    break;
                case "Prison":
                    f = new Prison(id, label, income, cost, seriesID);
                    break;
                default: System.out.println("No such type is available");
            }
        }
    }

    public Field getField(int id){
        return fields[id-1];
    }
}
