package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages multiple BankAccount objects, providing methods
 * for adding accounts, closing them, applying global interest, etc.
 */
public class BankAccountsManager {

  private final List<BankAccount> accounts;

  /**
   * Creates an empty manager for BankAccount objects.
   */
  public BankAccountsManager() {
    this.accounts = new ArrayList<>();
  }

  /**
   * Adds a new BankAccount to the manager.
   *
   * @param account The account to be added.
   * @throws IllegalArgumentException if the account is null.
   */
  public void addAccount(BankAccount account) {
    if (account == null) {
      throw new IllegalArgumentException("Cannot add a null account.");
    }
    accounts.add(account);
  }

  /**
   * Closes all accounts by setting their balance to 0
   * and then clearing the manager's list.
   */
  public void closeAllAccounts() {
    for (BankAccount acc : accounts) {
      acc.closeAccount();
    }
    accounts.clear();
  }

  /**
   * Finds the richest account in the manager.
   *
   * @return The account with the highest balance, or null if no accounts exist.
   */
  public BankAccount findRichestAccount() {
    if (accounts.isEmpty()) {
      return null;
    }
    BankAccount richest = accounts.get(0);
    for (BankAccount acc : accounts) {
      if (acc.getBalance() > richest.getBalance()) {
        richest = acc;
      }
    }
    return richest;
  }

  /**
   * Applies the global/default interest rate to all accounts in the manager.
   */
  public void applyGlobalInterestRate() {
    for (BankAccount acc : accounts) {
      acc.applyInterest();
    }
  }

  /**
   * Transfers an amount between two different accounts.
   *
   * @param from The source account.
   * @param to The target account.
   * @param amount The amount to transfer (must be {@literal >} 0 and {@literal <=} 'from' balance).
   * @throws IllegalArgumentException if 'from' or 'to' is null, or amount {@literal <=} 0.
   */
  public void transfer(BankAccount from, BankAccount to, double amount) {
    if (from == null || to == null) {
      throw new IllegalArgumentException("Source or target account cannot be null.");
    }
    if (from == to) {
      throw new IllegalArgumentException("Cannot transfer to the same account.");
    }
    if (amount <= 0) {
      throw new IllegalArgumentException("Transfer amount must be > 0.");
    }
    from.withdraw(amount);
    to.deposit(amount);
  }

  /**
   * Returns an unmodifiable view of the managed accounts.
   *
   * @return a read-only list of accounts.
   */
  public List<BankAccount> getAccounts() {
    return Collections.unmodifiableList(accounts);
  }
}
