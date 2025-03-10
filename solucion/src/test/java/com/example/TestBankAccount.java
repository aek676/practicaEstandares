package com.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class TestBankAccount {

	private BankAccount account;

@BeforeEach
    void setUp() {
        account = new BankAccount("John Doe", 1000.0);
        BankAccount.setDefaultInterestRate(0.05);
    }

    @Test
    void testAccountCreation() {
        assertEquals("John Doe", account.getHolderName());
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void testDeposit() {
        account.deposit(500);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    void testWithdraw() {
        account.withdraw(400);
        assertEquals(600.0, account.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(2000));
    }

    @Test
    void testApplyInterest() {
        account.applyInterest();
        assertEquals(1050.0, account.getBalance());
    }

    @Test
    void testApplyZeroInterest() {
        BankAccount.setDefaultInterestRate(0.0);
        account.applyInterest();
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void testApplyRandomBonus() {
        double initialBalance = account.getBalance();
        account.applyRandomBonus();
        assertTrue(account.getBalance() > initialBalance);
    }

    @Test
    void testTransactionHistory() {
        account.deposit(200);
        account.withdraw(100);
        List<String> history = account.getTransactionHistory();
        assertEquals(3, history.size());
    }

    @Test
    void testCloseAccount() {
        account.closeAccount();
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void testSetHolderName() {
        account.setHolderName("Jane Smith");
        assertEquals("Jane Smith", account.getHolderName());
    }

    @Test
    void testSetInvalidHolderName() {
        assertThrows(IllegalArgumentException.class, () -> account.setHolderName(""));
    }

    @Test
    void testSetGlobalBankName() {
        BankAccount.setGlobalBankName("NEW-BANK");
        assertEquals("NEW-BANK", BankAccount.getGlobalBankName());
    }

    @Test
    void testSetInvalidGlobalBankName() {
        assertThrows(IllegalArgumentException.class, () -> BankAccount.setGlobalBankName(""));
    }

    @Test
    void testSetNegativeInterestRate() {
        assertThrows(IllegalArgumentException.class, () -> BankAccount.setDefaultInterestRate(-0.1));
    }
}