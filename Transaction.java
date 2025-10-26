import java.time.LocalDateTime;

public class Transaction {
    private final String type;         // "DEPOSIT" or "WITHDRAW"
    private final double amount;
    private final LocalDateTime timestamp;

    public Transaction(String type, double amount, LocalDateTime timestamp) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
