package practica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase escrita con intencional mala práctica, para que dediques tiempo
 * arreglándola.
 */
public class bankaccount { // Nombre en minúscula, rompe convenciones

    // Variables públicas/static sin validaciones ni encapsulación
    public static double DEFAULT_INTEREST_RATE;
    public static String GLOBAL_BANK_NAME = "BANK-MX";

    double balance;
    String holderName;
    List<String> transactionHistory; // Sin encapsulación

    // Constructor sin validaciones de saldo ni del nombre
    public bankaccount(String name, double initialBalance) {
        this.holderName = name;
        this.balance = initialBalance;
        transactionHistory = new ArrayList<>();
        transactionHistory.add("Cuenta creada para " + name + " con saldo: " + initialBalance);
    }

    // No valida si el monto <= 0
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Se depositaron " + amount + " | Saldo ahora: " + balance);
    }

    // No valida si el monto <= 0 ni si el saldo se vuelve negativo
    public void withdraw(double amount) {
        balance -= amount;
        transactionHistory.add("Se retiraron " + amount + " | Saldo ahora: " + balance);
    }

    // Aplica un interés estático sin comprobar si es negativo o excesivo
    public void applyInterest() {
        double interest = balance * DEFAULT_INTEREST_RATE;
        balance += interest;
        transactionHistory.add("Aplicado interés de " + interest + " usando rate " + DEFAULT_INTEREST_RATE);
    }

    // Método que cambia el titular sin ninguna verificación (puede ser null)
    public void changeHolder(String newHolder) {
        transactionHistory.add("Titular cambiado de " + holderName + " a " + newHolder);
        holderName = newHolder;
    }

    // Añade un "bono" aleatorio sin razonarlo
    public void randomBonus() {
        Random r = new Random();
        int bonus = r.nextInt(1000);
        balance += bonus;
        transactionHistory.add("Bono aleatorio de: " + bonus + " | Saldo: " + balance);
    }

    // Devuelve historial sin filtrar, podría ser un vector de inseguridad
    public List<String> getHistory() {
        return transactionHistory;
    }

    // No se usa, pero complica la clase
    public static void main(String[] args) {
        bankaccount acc = new bankaccount("Pedro", 1000);
        acc.deposit(500);
        acc.applyInterest();
        acc.randomBonus();
        System.out.println("Saldo final: " + acc.balance);
    }
}
