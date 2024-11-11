public class Board {
    private Field[] fields;
    private CardDeck cardDeck;
    static public int fieldSize;

    public Board(String[] fielddata, String[] carddata){
        createFields(fielddata);
        this.cardDeck = new CardDeck(carddata);
    }

    private void createFields(String[] data){
        fields = new Field[data.length];
        for (int i = 0; i < data.length; i++){
            String[] values = data[i].split(",");
            int id = Integer.parseInt(values[0].trim());
            String label = values[2].trim();
            int cost = Integer.parseInt(values[3].trim());
            int income = Integer.parseInt(values[4].trim());
            fields[i] = new Field(id,label,cost,income);
        }
        fieldSize = fields.length;
    }

    public Field getField(int id){
        return fields[id-1];
    }
}
