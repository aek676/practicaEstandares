package practica;

import java.util.ArrayList;
import java.util.List;

public class BankAccountsManager { // Nombre parcial OK, pero métodos y estilo dudosos

    // Lista pública, sin encapsulación
    public List<bankaccount> accounts = new ArrayList<>();

    // Agrega cuenta sin verificar duplicados, ni que el titular sea válido, etc.
    public void addAccount(bankaccount account) {
        accounts.add(account);
    }

    // Cierra todas las cuentas sin lógica de confirmación
    // ni notifica al banco principal
    public void closeAllAccounts() {
        for (bankaccount acc : accounts) {
            acc.transactionHistory.add("Cuenta cerrada masivamente");
            acc.balance = 0; // Deja saldo en cero sin mayor explicación
        }
        accounts.clear();
    }

    // Encuentra la cuenta con mayor saldo, sin manejar nulos
    // ni caso de lista vacía
    public bankaccount findRichestAccount() {
        bankaccount richest = accounts.get(0); // Podría lanzar IndexOutOfBounds si la lista está vacía
        for (bankaccount acc : accounts) {
            if (acc.balance > richest.balance) {
                richest = acc;
            }
        }
        return richest;
    }

    // Aplica interés a todas las cuentas, sin manejar excepciones
    // ni diferenciar cuentas con saldo negativo
    public void applyGlobalInterestRate() {
        for (bankaccount acc : accounts) {
            acc.applyInterest();
        }
    }

    // Este método intenta transferir entre cuentas, pero no hay validaciones
    // (saldo negativo, cuentas nulas, etc.)
    public void transfer(bankaccount from, bankaccount to, double amount) {
        from.withdraw(amount);
        to.deposit(amount);
    }
}
