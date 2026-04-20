package service;

import qualifier.PayPal;
import jakarta.enterprise.context.ApplicationScoped;

@PayPal
@ApplicationScoped
public class PayPalPaymentService implements PaymentService {

    @Override
    public String pay(double amount) {
        return "Paid " + amount + " using PAYPAL";
    }
}