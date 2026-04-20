package event;

public class PaymentEvent {
    private double amount;

    public PaymentEvent(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}