import java.util.HashMap;

public class BankCustomer {
    private String id;
    private String name;
    private String email;
    private Double balance;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public BankCustomer(String id, String name, String email, Double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }
}

class Bank {

    private HashMap<String, BankCustomer> customer;

    public Bank() {
        this.customer = new HashMap<>();
    }

    public HashMap<String, BankCustomer> getCustomer() {
        return customer;
    }

    public void addCustomer(BankCustomer cust){
        if(customer.keySet().contains(cust.getId())){
            throw new RuntimeException("Customer Already Exists");
        }
        else{
            customer.put(cust.getId(), cust);
        }
    }

    public void removeCustomer(String id){
        if(customer.keySet().contains(id)){
            customer.remove(id);
        }
        else{
            throw new RuntimeException("Customer Does not Exist");
        }
    }

    public Double getCustomerBalance(String id) {
        Double balance = 0.0;
        if(customer.keySet().contains(id)){
            balance = customer.get(id).getBalance();
        }
        else{
            throw new RuntimeException("Customer does not exist");
        }
        return balance;
    }

    public void deposit(String id, double amount) {
        if(amount < 0.0) {
            throw new RuntimeException("Deposit amount must be positive");
        }
        else {
            if (customer.keySet().contains(id)) {
                customer.get(id).setBalance(getCustomerBalance(id) + amount);
            } else {
                throw new RuntimeException("Customer does not exist");
            }
        }
    }

    public void withdraw(String id, double amount) {
        if(amount < 0.0) {
            throw new RuntimeException("Withdrawal amount must be positive");
        }
        else {
            if (customer.keySet().contains(id)) {
                if(getCustomerBalance(id) < amount){
                    throw new RuntimeException("Insufficient balance");
                }
                else {
                    customer.get(id).setBalance(getCustomerBalance(id) - amount);
                }
            } else {
                throw new RuntimeException("Customer does not exist");
            }
        }
    }
}
