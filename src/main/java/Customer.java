//Create a Customer class that contains a name, age, and a list of Order objects.
//        An Order object should contain an order number and a list of Product objects.
//        A Product object should contain a name and a price.
//        Implement a method that takes a list of Customer objects and returns the name of the oldest customer
//        who has placed at least one order containing at least one product with a price greater than $50.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer{


    String name;
    int age;
    List<Order> order;

    public Customer(String name, int age, List<Order> order) {
        this.name = name;
        this.age = age;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Order> getOrder() {
        return order;
    }
    public static String getOldestCustomer(List<Customer> customer){
        Map<Integer, String> targetCustomers = new HashMap<>();
        for(Customer cust: customer){
            List<Order> ord = cust.getOrder();
            for(Order order1: ord){
                List<Product> prod = order1.getProduct();
                for(Product product: prod){
                    if(order1.getOrderNumber() != 0 && product.price > 50.00){
                       targetCustomers.put(cust.age, cust.name);
                    }
                }
            }
        }
        List<Integer> custAge = new ArrayList<>(targetCustomers.keySet());
        int maxAge = 0;
        for(int age: custAge){
            if(age > maxAge)
                maxAge = age;
        }
        return targetCustomers.get(maxAge);
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("iPhone12", 799.99));
        products.add(new Product("iPhone13", 899.99));
        products.add(new Product("iPhone14", 999.99));
        products.add(new Product("iPhone15", 10.99));


        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, List.of(products.get(0))));
        orders.add(new Order(2, List.of(products.get(1))));
        orders.add(new Order(3, List.of(products.get(2))));
        orders.add(new Order(4, List.of(products.get(3))));

        List<Customer> customers = new ArrayList<>();
        //customers.add(new Customer("Ram", 35, List.of(new Order(1, List.of(new Product("iPhone", 999.99))))));
        customers.add(new Customer("Ram", 80, List.of()));
        customers.add(new Customer("Virat", 40, List.of(orders.get(1))));
        customers.add(new Customer("Sachin", 50, List.of(orders.get(2))));
        customers.add(new Customer("Rajni", 70, List.of(orders.get(3))));
        System.out.println("Oldest Customer with at least one order is : "+getOldestCustomer(customers));
    }

}

class Order{
    int orderNumber;
    List<Product> product;

    public Order(int orderNumber, List<Product> product) {
        this.orderNumber = orderNumber;
        this.product = product;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<Product> getProduct() {
        return product;
    }
}

class Product{
    String name;
    Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

}