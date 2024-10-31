import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Customer> customers;
    private TextUI ui;
    private FileIO io;

    public Bank(String name) {
        this.name = name;
        customers = new ArrayList<>();
        ui = new TextUI();
        io = new FileIO();
    }
    public void addCustomer(Customer c){
        this.customers.add(c);
    }
    public String toString(){
        String s = "";
        for (Customer c:customers) {
            s+=c+"\n";
        }
        return s;
    }


    public List getCustomers() {
            return customers;
    }

    public void registerCustomer() {

        String continueDialog = "Y";
        while (continueDialog.equalsIgnoreCase("Y")) {


            String name = ui.promptText("Type name of customer:");


            int startAmount = ui.promptNumeric("Type start amount:");


            Customer c = new Customer(name, startAmount);
            this.addCustomer(c);


            continueDialog = ui.promptText("Do you wish to create another customer?Y/N");


        }
    }
   public void createCustomersFromData(){
     ArrayList<String> data = io.readData("data/customerdata.csv");

       if(!data.isEmpty()) {
           for (String s:data) {
               String[] values= s.split(",");
               String name = values[0];
               int balance = Integer.parseInt(values[1].trim());
               Customer c = new Customer(name, balance);
               customers.add(c);
           }
       }
   }
    public void endSession(){

        ArrayList<String> customersAsText = new ArrayList<>();
        for (Customer c:customers) {
            customersAsText.add(c.toString());
        }
        FileIO.saveData(customersAsText, "data/customerdata.csv", "name, balance");
    }

}
