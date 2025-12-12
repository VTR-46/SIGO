package model.services;

public interface OnlinePaymentService {

        double paymentFee(double updatedQuota);
        double interest(double amount, int months);


}
