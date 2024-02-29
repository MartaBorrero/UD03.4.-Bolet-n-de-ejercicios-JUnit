package es.iessoterohernandez.daw.endes.EjJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


public class TestAccount {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account("John Doe", 123456789, 1000);
    }

    @Test
    public void testDeposit() {
        assertTrue(account.deposit(500)); // Valid deposit
        assertFalse(account.deposit(-200)); // Invalid deposit
    }

    @Test
    public void testWithdraw() {
        assertTrue(account.withdraw(500, 0)); // Valid withdrawal
        assertFalse(account.withdraw(-200, 0)); // Invalid withdrawal amount
        assertFalse(account.withdraw(2000, 0)); // Withdrawal amount exceeds balance
        assertFalse(account.withdraw(500, -50)); // Negative fee
    }

    @Test
    public void testAddInterest() {
        account.addInterest();
        assertEquals(1045.0f, account.getBalance(), 0.01f); // Testing interest calculation
    }

    @Test
    public void testToString() {
        String expected = "123456789\tJohn Doe\t$1,000.00";
        assertEquals(expected, account.toString()); // Testing toString method
    }

    
    
    
    

    
    
    
    
    
    
    @Test
    public void testInitialBalance() {
        assertEquals(1000, account.getBalance(), 0.01f); // Testing initial balance
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(123456789, account.getAccountNumber()); // Testing account number
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", account.name); // Testing account holder name
    }

    @Test
    public void testNegativeInitialBalance() {
        Account negativeBalanceAccount = new Account("Jane Smith", 987654321, -500);
        assertEquals(0, negativeBalanceAccount.getBalance(), 0.01f); // Initial balance should be 0 for negative initial balance
    }

    @Test
    public void testWithdrawWithFee() {
        // Ensure fee is correctly applied to withdrawal
        assertTrue(account.withdraw(500, 50)); // Valid withdrawal with fee
        assertEquals(450.0f, account.getBalance(), 0.01f); // Balance after withdrawal with fee
    }
}







