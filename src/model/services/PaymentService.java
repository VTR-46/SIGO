package model.services;

import model.entities.Payment;

public interface PaymentService {

    abstract double fee(Payment payment);

    default double netPayment(Payment payment){
        double amount = payment.getAmount();
        double tax = fee(payment);
        return amount - tax;
    }

}
