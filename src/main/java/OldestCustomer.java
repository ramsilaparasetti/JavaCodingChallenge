//Create a Customer class that contains a name, age, and a list of Order objects.
//        An Order object should contain an order number and a list of Product objects.
//        A Product object should contain a name and a price.
//        Implement a method that takes a list of Customer objects and returns the name of the oldest customer
//        who has placed at least one order containing at least one product with a price greater than $50.


import java.util.ArrayList;

public class OldestCustomer {


    String repoName;
    String name;
    String age;
    int orderNumber;

    public OldestCustomer(String repoName, String name, String age, int orderNumber) {
        this.repoName = repoName;
        this.name = name;
        this.age = age;
        this.orderNumber = orderNumber;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerWithHighestOrders(ArrayList<OldestCustomer> customer){
        int maxOrder = 0;
        String customerName = "";
        for(OldestCustomer cust: customer){
            if(cust.getOrderNumber() > maxOrder){
                maxOrder = cust.getOrderNumber();
                customerName = cust.getName();
            }
        }
        return customerName;
    }

    public static void main(String[] args) {
        ArrayList<OldestCustomer> customerInfo = new ArrayList<>();
        customerInfo.add(new OldestCustomer("GitCoPilotTest", "Ram", "25", 5));
        customerInfo.add(new OldestCustomer("GitCoPilotTest", "Shyam", "30", 10));
        customerInfo.add(new OldestCustomer("GitCoPilotTest", "Hari", "35", 15));
        customerInfo.add(new OldestCustomer("GitCoPilotTest", "Gita", "40", 20));
        customerInfo.add(new OldestCustomer("GitCoPilotTest", "Sita", "45", 25));
        customerInfo.add(new OldestCustomer("GitCoPilotTest", "Rita", "50", 30));
        customerInfo.add(new OldestCustomer("GitCoPilotTest", "Ramesh", "55", 35));
        customerInfo.add(new OldestCustomer("GitCoPilotTest", "Suresh", "60", 40));
        customerInfo.add(new OldestCustomer("GitCoPilotTest", "Raju", "65", 45));
        customerInfo.add(new OldestCustomer("GitCoPilotTest", "Rajesh", "70", 50));
        customerInfo.add(new OldestCustomer("GitCoPilotTest", "Raj", "75", 55));
        customerInfo.add(new OldestCustomer("GitCoPilotTest", "Rajendra", "80", 60));
        OldestCustomer customer = new OldestCustomer("GitCoPilotTest", "Rajendra", "80", 60);

        System.out.println(customer.getCustomerWithHighestOrders(customerInfo));
    }
}
