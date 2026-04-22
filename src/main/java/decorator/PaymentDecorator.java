package decorator;

import jakarta.annotation.Priority;
import qualifier.CreditCard;
import service.PaymentService;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.inject.Inject;

import static jakarta.interceptor.Interceptor.Priority.APPLICATION;

@Decorator
@Priority(APPLICATION + 10)
public abstract class PaymentDecorator implements PaymentService {

    @Inject
    @Delegate
    @CreditCard
    private PaymentService delegate;

    @Override
    public String pay(double amount) {
        return delegate.pay(amount) + " [decorated: extra logging]";
    }
}