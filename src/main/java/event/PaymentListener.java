package event;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class PaymentListener {

    public void onPayment(@Observes PaymentEvent event) {
        System.out.println("EVENT: Payment processed: " + event.getAmount());
    }
}