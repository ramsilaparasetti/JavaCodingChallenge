//  Implement a class called BankAccount that represents a bank account with attributes like account number,
//  account holder name, and balance. Add methods to deposit and withdraw money from the account
//  and calculate the interest earned over a certain period of time.

public class BankAccount {


    int accountNumber;
    String name;
    Double balance;
    public BankAccount(int accountNumber, String name, Double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public static void depositMoney(BankAccount account, Double depositMoney){
        account.setBalance(account.getBalance() + depositMoney);
        System.out.println("Current balance after deposit is : "+account.getBalance());
    }

    public static void withdrawMoney(BankAccount account, Double withdrawMoney){
        if(account.getBalance() < withdrawMoney){
            System.out.println("You dont have enough money in your account, your current balance is : "+account.getBalance());
        }
        else {
            account.setBalance(account.getBalance() - withdrawMoney);
            System.out.println("Current balance after withdrawal is : "+account.getBalance());
        }

    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(12345, "Ram", 25000.00);
        depositMoney(account, 25000.00);
        withdrawMoney(account, 125000.00);
        withdrawMoney(account, 35000.00);
    }
}
