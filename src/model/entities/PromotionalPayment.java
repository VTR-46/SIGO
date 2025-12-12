package model.entities;

import model.services.PaymentService;

public class PromotionalPayment implements PaymentService {
    @Override
    public double fee(Payment payment) {
        return 0;
    }

    @Override
    public double netPayment(Payment payment) {
        double amont = payment.getAmount();
        double bonus = payment.getAmount() * 0.02;
        return amont + bonus;
    }
}
