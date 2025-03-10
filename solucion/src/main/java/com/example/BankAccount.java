package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a bank account with basic operations:
 * deposit, withdraw, apply interest, and track a transaction history.
 */
public class BankAccount {

  private static double defaultInterestRate = 0.0;
  private static String globalBankName = "BANK-MX";

  private double balance;
  private String holderName;
  private final List<String> transactionHistory;

  /**
   * Creates a bank account with a given name and initial balance.
   *
   * @param name The name of the account holder (non-null and non-empty).
   * @param initialBalance The initial balance (must be >= 0).
   * @throws IllegalArgumentException if name is invalid or balance is negative.
   */
  public BankAccount(String name, double initialBalance) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Holder name cannot be null or empty.");
    }
    if (initialBalance < 0) {
      throw new IllegalArgumentException("Initial balance cannot be negative.");
    }
    this.holderName = name;
    this.balance = initialBalance;
    this.transactionHistory = new ArrayList<>();
    transactionHistory.add("Account created for " + name + " with balance: " + initialBalance);
  }

  /**
   * Deposits an amount into the account.
   *
   * @param amount The amount to deposit (must be {@literal > 0}).
   * @throws IllegalArgumentException if amount {@literal <=} 0.
   */
  public void deposit(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Deposit amount must be greater than 0.");
    }
    balance += amount;
    transactionHistory.add("Deposited " + amount + " | New balance: " + balance);
  }

  /**
   * Withdraws an amount from the account.
   *
   * @param amount The amount to withdraw (must be {@literal >} 0 and {@literal <=} current balance).
   * @throws IllegalArgumentException if amount {@literal <=} 0 or amount {@literal >} current balance.
   */
  public void withdraw(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Withdraw amount must be greater than 0.");
    }
    if (amount > balance) {
      throw new IllegalArgumentException("Insufficient balance to withdraw " + amount);
    }
    balance -= amount;
    transactionHistory.add("Withdrew " + amount + " | New balance: " + balance);
  }

  /**
   * Applies the default interest rate to the current balance.
   * If the interest rate is negative, no interest is applied.
   */
  public void applyInterest() {
    if (defaultInterestRate > 0) {
      double interest = balance * defaultInterestRate;
      balance += interest;
      transactionHistory.add("Applied interest: " + interest
          + " at rate " + defaultInterestRate
          + " | New balance: " + balance);
    } else {
      transactionHistory.add("No interest applied (rate <= 0).");
    }
  }

  /**
   * Gives a random bonus to the account. 
   * The bonus is a random integer between 1 and 1000.
   */
  public void applyRandomBonus() {
    Random random = new Random();
    int bonus = random.nextInt(1000) + 1; // Range 1..1000
    balance += bonus;
    transactionHistory.add("Random bonus of " + bonus + " applied | New balance: " + balance);
  }

  /**
   * Returns an unmodifiable list of transaction history entries.
   *
   * @return A list of transaction strings.
   */
  public List<String> getTransactionHistory() {
    return List.copyOf(transactionHistory);
  }

  /**
   * Closes the account, setting balance to zero and adding a transaction note.
   */
  public void closeAccount() {
    transactionHistory.add("Account closed for " + holderName
        + " | Final balance was " + balance);
    balance = 0.0;
  }

  /**
   * Changes the account holder name.
   * @param newHolder The new holder name (non-null, non-empty).
   * @throws IllegalArgumentException if newHolder is invalid
   */
  public void setHolderName(String newHolder) {
    if (newHolder == null || newHolder.trim().isEmpty()) {
      throw new IllegalArgumentException("New holder name cannot be null/empty.");
    }
    transactionHistory.add("Changed holder name from " + holderName + " to " + newHolder);
    holderName = newHolder;
  }
  
  /**
   * Retrieves the name of the account holder.
   *
   * @return the name of the account holder.
   */
  public String getHolderName() {
    return holderName;
  }
  
  /**
   * Retrieves the current balance of the bank account.
   *
   * @return the current balance as a double.
   */
  public double getBalance() {
    return balance;
  }
  
  /**
   * Returns the default interest rate for bank accounts.
   *
   * @return the default interest rate as a double.
   */
  public static double getDefaultInterestRate() {
    return defaultInterestRate;
  }

  /**
   * Sets the default interest rate to be applied to all accounts.
   *
   * @param rate The new rate (must be >= 0).
   */
  public static void setDefaultInterestRate(double rate) {
    if (rate < 0) {
      throw new IllegalArgumentException("Interest rate cannot be negative.");
    }
    defaultInterestRate = rate;
  }
  
  /**
   * Retrieves the global bank name.
   *
   * @return the global bank name as a String.
   */
  public static String getGlobalBankName() {
    return globalBankName;
  }
  
  /**
   * Sets the global bank name.
   *
   * @param globalBankNameParam the name of the global bank to set
   * @throws IllegalArgumentException if the bank name is null or empty
   */
  public static void setGlobalBankName(String globalBankNameParam) {
    if (globalBankNameParam == null || globalBankNameParam.trim().isEmpty()) {
      throw new IllegalArgumentException("Bank name cannot be null or empty.");
    }
    globalBankName = globalBankNameParam;
  }
}

