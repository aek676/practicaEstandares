package com.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class TestBankAccountManager {

	private BankAccountsManager manager;
    private BankAccount account1;
    private BankAccount account2;

    @BeforeEach
    void setUp() {
        manager = new BankAccountsManager();
        account1 = new BankAccount("Alice", 1000);
        account2 = new BankAccount("Bob", 2000);
        manager.addAccount(account1);
        manager.addAccount(account2);
    }

    @Test
    void testAddAccount() {
        BankAccount newAccount = new BankAccount("Charlie", 500);
        manager.addAccount(newAccount);
        assertTrue(manager.getAccounts().contains(newAccount));
    }

    @Test
    void testAddNullAccount() {
        assertThrows(IllegalArgumentException.class, () -> manager.addAccount(null));
    }

    @Test
    void testCloseAllAccounts() {
        manager.closeAllAccounts();
        assertTrue(manager.getAccounts().isEmpty());
        assertEquals(0, account1.getBalance());
        assertEquals(0, account2.getBalance());
    }

    @Test
    void testFindRichestAccount() {
        assertEquals(account2, manager.findRichestAccount());
    }

    @Test
    void testFindRichestAccountEmptyManager() {
        BankAccountsManager emptyManager = new BankAccountsManager();
        assertNull(emptyManager.findRichestAccount());
    }

    @Test
    void testApplyGlobalInterestRate() {
        BankAccount.setDefaultInterestRate(0.1);
        manager.applyGlobalInterestRate();
        assertEquals(1100, account1.getBalance());
        assertEquals(2200, account2.getBalance());
    }

    @Test
    void testTransferBetweenAccounts() {
        manager.transfer(account1, account2, 500);
        assertEquals(500, account1.getBalance());
        assertEquals(2500, account2.getBalance());
    }

    @Test
    void testTransferInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> manager.transfer(account1, account2, -100));
    }

    @Test
    void testTransferInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> manager.transfer(account1, account2, 2000));
    }

    @Test
    void testTransferToSameAccount() {
        assertThrows(IllegalArgumentException.class, () -> manager.transfer(account1, account1, 100));
    }

    @Test
    void testTransferWithNullAccount() {
        assertThrows(IllegalArgumentException.class, () -> manager.transfer(null, account2, 100));
        assertThrows(IllegalArgumentException.class, () -> manager.transfer(account1, null, 100));
    }

    @Test
    void testWithdrawInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> account1.withdraw(0));
        assertThrows(IllegalArgumentException.class, () -> account1.withdraw(-100));
    }

    @Test
    void testCreateAccountWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(null, 100));
    }

    @Test
    void testCreateAccountWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("", 100));
    }

    @Test
    void testCreateAccountWithNegativeInitialBalance() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("David", -50));
    }

    @Test
    void testGetAccountsUnmodifiable() {
        List<BankAccount> accounts = manager.getAccounts();
        assertThrows(UnsupportedOperationException.class, () -> addAccount(accounts));
    }
    
    private void addAccount(List<BankAccount> accounts) {
        accounts.add(new BankAccount("New", 100));
    }
    

    @Test
    void testGetDefaultInterestRate() {
        BankAccount.setDefaultInterestRate(0.05);
        assertEquals(0.05, BankAccount.getDefaultInterestRate());
    }

    @Test
    void testSetGlobalBankName() {
        assertThrows(IllegalArgumentException.class, () -> BankAccount.setGlobalBankName(null));
        assertThrows(IllegalArgumentException.class, () -> BankAccount.setGlobalBankName(""));
        BankAccount.setGlobalBankName("MyBank");
    }

    @Test
    void testSetHolderName() {
        assertThrows(IllegalArgumentException.class, () -> account1.setHolderName(null));
        assertThrows(IllegalArgumentException.class, () -> account1.setHolderName(""));
        account1.setHolderName("NewAlice");
    }
}

