package service;

import interceptor.Logged;
import qualifier.CreditCard;
import jakarta.enterprise.context.ApplicationScoped;

@Logged
@CreditCard
@ApplicationScoped
public class CardPaymentService implements PaymentService {

    @Override
    public String pay(double amount) {
        return "Paid " + amount + " using CREDIT CARD";
    }
}