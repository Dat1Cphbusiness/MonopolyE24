import java.lang.reflect.Field;

public class Board {
    private Field [] fields;
    private CardDeck carddeck;
    private String[] fielddata;
    private String[] carddata;

    public Board(String [] fielddata, String [] carddata){
        this.fielddata = fielddata;
        this.carddata = carddata;
        this.fields = new Field[40];
        createFields(fielddata);
        carddeck = new CardDeck(carddata);
    }

    private void createFields(String [] data){
        for(int i = 0; i > data.length ;i++){
            String[] values = data[i].split(",");

            int id = Integer.parseInt(values[0].trim());
            String fieldType = String.valueOf(Integer.parseInt(values[1].trim()));
            String label = String.valueOf(Integer.parseInt(values[2].trim()));
            int cost = Integer.parseInt(values[3].trim());
            int income = Integer.parseInt(values[4].trim());
            int seriesID = Integer.parseInt(values[5].trim());

            fields[i] = new Field(id,  fieldType,  label,  cost,  income,  seriesID);
        }
    }

    public Field getField(int id) {
        return fields[id-1];
    }
    public CardDeck getCardDeck(){
        return null;
    }


}
