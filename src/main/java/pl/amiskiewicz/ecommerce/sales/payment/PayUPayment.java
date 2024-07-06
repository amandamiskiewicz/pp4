package pl.amiskiewicz.ecommerce.sales.payment;

import pl.amiskiewicz.ecommerce.sales.payment.PaymentDetails;
import pl.amiskiewicz.ecommerce.sales.payment.PaymentGateway;
import pl.amiskiewicz.ecommerce.sales.payment.RegisterPaymentRequest;
public class PayUPayment implements PaymentGateway {
    @Override
    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
        return null;
    }
}
