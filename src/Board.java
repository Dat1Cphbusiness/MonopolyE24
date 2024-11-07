public class Board {
    private Field[] fields;
    private CardDeck cardDeck;

    public Board(String[] fielddata, String[] carddata){
        createFields(fielddata);
        this.cardDeck = new CardDeck(carddata);
    }

    private void createFields(String[] data){
        fields = new Field[data.length];
        for (int i = 0; i < data.length; i++){
            String[] values = data[i].split(",");
            int id = Integer.parseInt(values[0].trim());
            int label = Integer.parseInt(values[1].trim());
            int cost = Integer.parseInt(values[2].trim());
            int income = Integer.parseInt(values[3].trim());
            fields[i] = new Field(id,label,cost,income);
        }
    }

    public Field getField(int id){
        return fields[id];
    }
}
