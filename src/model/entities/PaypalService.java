package model.entities;

import model.services.OnlinePaymentService;

public class PaypalService implements OnlinePaymentService {

    @Override
    public double paymentFee(double amount) {
        return amount * 0.02; // 2% taxa
    }

    @Override
    public double interest(double amount, int months) {
        return amount * 0.01 * months; // 1% por mês
    }
}

