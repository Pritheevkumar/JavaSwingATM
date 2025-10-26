import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Account {
    private final String cardNumber;
    private final String pin;
    private double balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String cardNumber, String pin, double initialBalance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public String getCardNumber() { return cardNumber; }
    public String getPin() { return pin; }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized boolean withdraw(double amount) {
        if (amount <= 0) return false;
        if (amount > balance) return false;
        balance -= amount;
        transactions.add(new Transaction("WITHDRAW", amount, LocalDateTime.now()));
        return true;
    }

    public synchronized boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        transactions.add(new Transaction("DEPOSIT", amount, LocalDateTime.now()));
        return true;
    }

    public synchronized List<Transaction> getTransactions() {
        return new ArrayList<>(transactions); // defensive copy
    }
}
