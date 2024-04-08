import java.util.ArrayList;

public class Card {
    private String message;
    private int income;
    private int cost;
    private String event;

    public Card(String message, int income, int cost, String event){

        this.message = message;
        this.income = income;
        this.cost = cost;
        this.event = event;
    }

    @Override
    public String toString() {
        return message;
    }

    public int getCost() {
        return this.cost;
    }

    public int getIncome() {
        return income;
    }

    public String getEvent() {
        return event;
    }

    public String getMessage() {
        return message;
    }
}
