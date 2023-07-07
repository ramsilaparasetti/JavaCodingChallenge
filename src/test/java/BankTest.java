import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class BankTest {

    private Bank bank;

    BankCustomer customer1 = new BankCustomer("1", "John1", "abc1@email.com", 150.0);
    BankCustomer customer2 = new BankCustomer("2", "John2", "abc2@email.com", 250.0);
    BankCustomer customer3 = new BankCustomer("3", "John3", "abc3@email.com", 350.0);
    BankCustomer customer4 = new BankCustomer("4", "John4", "abc4@email.com", 450.0);
    BankCustomer customer5 = new BankCustomer("5", "John5", "abc5@email.com", 550.0);

    @Before
    public void setup(){
       bank = new Bank();
       bank.addCustomer(customer1);
       bank.addCustomer(customer2);
    }

    @Test
    public void test_addCustomer_GivenNewCustomer() {
        bank.addCustomer(customer3);
        assertEquals(3, bank.getCustomer().size());
    }

    @Test
    public void test_addCustomer_ThrowsException_GivenExistingCustomer() {
        Exception exception = assertThrows(RuntimeException.class, () -> bank.addCustomer(customer1));
        String expectedMessage = "Customer Already Exists";
        assertTrue(exception.getMessage().equals(expectedMessage));
    }

    @Test
    public void test_removeCustomer_GivenExistingCustomer() {
        bank.removeCustomer("1");
        assertEquals(1, bank.getCustomer().size());
    }

    @Test
    public void test_removeCustomer_throwsException_givenInvalidCustomer() {
        Exception exception = assertThrows(RuntimeException.class, () -> bank.removeCustomer("5"));
        String expectedMessage = "Customer Does not Exist";
        assertTrue(exception.getMessage().equals(expectedMessage));
    }

    @Test
    public void test_getCustomerBalance_giveExistingCustomerID() {
        assertEquals(Optional.of(250.0), Optional.of(bank.getCustomerBalance("2")));
    }

    @Test
    public void test_getCustomerBalance_throwsException_giveInvalidCustomerID() {
        Exception exception = assertThrows(RuntimeException.class, () -> bank.getCustomerBalance("80"));
        String expectedMessage = "Customer does not exist";
        assertTrue(exception.getMessage().equals(expectedMessage));
    }

    @Test
    public void test_deposit_givenValidAmount() {
        bank.deposit("2", 250.0);
        assertEquals(Optional.of(500.0), Optional.of(bank.getCustomerBalance("2")));
    }

    @Test
    public void test_deposit_throwsException_givenNegativeAmount() {
        Exception exception = assertThrows(RuntimeException.class, () -> bank.deposit("2", -250.0));
        String expectedMessage = "Deposit amount must be positive";
        assertTrue(exception.getMessage().equals(expectedMessage));
    }

    @Test
    public void test_deposit_throwsException_givenCustomerDoesNotExist() {
        Exception exception = assertThrows(RuntimeException.class, () -> bank.deposit("20", 250.0));
        String expectedMessage = "Customer does not exist";
        assertTrue(exception.getMessage().equals(expectedMessage));
    }

    @Test
    public void test_withdraw_givenValidAmount() {
        bank.withdraw("2", 50.0);
        assertEquals(Optional.of(200.0), Optional.of(bank.getCustomerBalance("2")));
    }

    @Test
    public void test_withdraw_throwsException_givenNegativeAmount() {
        Exception exception = assertThrows(RuntimeException.class, () -> bank.withdraw("2", -50.0));
        String expectedMessage = "Withdrawal amount must be positive";
        assertTrue(exception.getMessage().equals(expectedMessage));
    }

    @Test
    public void test_withdraw_throwsException_givenCustomerDoesNotExist() {
        Exception exception = assertThrows(RuntimeException.class, () -> bank.withdraw("20", 250.0));
        String expectedMessage = "Customer does not exist";
        assertTrue(exception.getMessage().equals(expectedMessage));
    }

    @Test
    public void test_withdraw_throwsException_givenAmountMoreThanBalance() {
        Exception exception = assertThrows(RuntimeException.class, () -> bank.withdraw("2", 2500.0));
        String expectedMessage = "Insufficient balance";
        assertTrue(exception.getMessage().equals(expectedMessage));
    }
}