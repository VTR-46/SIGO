package model.entities;

import model.services.PaymentService;

public class CardPayment implements PaymentService {

    @Override
    public double fee(Payment payment) {
        double amount = payment.getAmount();
        return (amount * 0.02) + 1.00;
    }

    public double netPayment(Payment payment) {
        double amount = payment.getAmount();
        double tax = fee(payment);
        return amount - tax;
    }
}
